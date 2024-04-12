package com.reimbursement.project.service.impl;

import com.reimbursement.project.dto.*;
import com.reimbursement.project.entity.Batches;
import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.entity.Expenses;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.exception.ResourceNotFoundException;
import com.reimbursement.project.repository.BatchesRepository;
import com.reimbursement.project.repository.EmployeeDetailsRepository;
import com.reimbursement.project.repository.TravelFormRepository;
import com.reimbursement.project.repository.service.BatchesRepoService;
import com.reimbursement.project.repository.service.EmployeeDetailsRepoService;
import com.reimbursement.project.repository.service.TravelFormRepoService;
import com.reimbursement.project.service.BatchesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchesServiceImpl implements BatchesService {

    private final TravelFormRepoService travelFormRepoService;

    private final BatchesRepoService batchesRepoService;

    private final ModelMapper modelMapper;

    private final EmployeeDetailsRepoService employeeDetailsRepoService;

    @Override
    public ResponseEntity<ResponseDto> createBatch(BatchesRequestDto batchesRequestDto) {
        Long empId=batchesRequestDto.getEmployeeDetails().getEmpId();
        Date fromDate=batchesRequestDto.getFromDate();
        Date toDate=batchesRequestDto.getToDate();
        String firstName= batchesRequestDto.getEmployeeDetails().getFirstName();

        EmployeeDetails employeeDetails=employeeDetailsRepoService.toFindByEmpId(empId);

        Batches batches=new Batches();
        batches.setFromDate(fromDate);
        batches.setToDate(toDate);
        batches.setEmployeeDetails(employeeDetails);
        batches.setReference(batchesRequestDto.getReferences());
        Date date=new Date();
        batches.setDate(date);
        batchesRepoService.toSave(batches);

        List<TravelForm> travelForms = travelFormRepoService.filters(fromDate,toDate,firstName,empId);
        if(travelForms!=null){
            List<BatchesFilterResponseDto> batchesFilterResponseDto=new ArrayList<>();
            for(TravelForm travelForm:travelForms){
                Batches batches1 = batchesRepoService.toFindById(batches.getId()).get();
                travelForm.setBatch(batches1);
                travelFormRepoService.toSave(travelForm);

                BatchesFilterResponseDto batchesFilterResponseDtoList=new BatchesFilterResponseDto();
                batchesFilterResponseDtoList.setId(travelForm.getId());
                batchesFilterResponseDtoList.setColleaguesDto(travelForm.getColleagueDetails());
                batchesFilterResponseDtoList.setManagerName(travelForm.getManagers().getManagerName());
                batchesFilterResponseDtoList.setDescription(travelForm.getDescription());
                batchesFilterResponseDtoList.setProjectName(travelForm.getProject().getProjectName());
                batchesFilterResponseDtoList.setApplyDate(travelForm.getApplyDate());
                batchesFilterResponseDtoList.setNumberOfPeople(travelForm.getNumberOfPeople());
                batchesFilterResponseDtoList.setPurposeOfVisit(travelForm.getPurposeOfVisit().getPurposes());
                batchesFilterResponseDtoList.setTravelDate(travelForm.getTravelDate());
                List<Expenses> expenses=travelForm.getExpenses();
                List<ExpenseResponseDto> expenseResponseDtoList=new ArrayList<>();
                for(Expenses expenses1:expenses){
                    expenseResponseDtoList.add(convertToExpensesDto(expenses1));
                }
                batchesFilterResponseDtoList.setExpenseResponseDto(expenseResponseDtoList);
                batchesFilterResponseDto.add(batchesFilterResponseDtoList);
            }
            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Travel forms within the specified dates are fetched successfully",batchesFilterResponseDto));
        }
    throw new ResourceNotFoundException("No travel forms are found within the specified date");
    }

    private ExpenseResponseDto convertToExpensesDto(Expenses expenses1) {
        ExpenseResponseDto expenseResponseDto=modelMapper.map(expenses1,ExpenseResponseDto.class);
        return expenseResponseDto;
    }


    @Override
    public ResponseEntity<ResponseDto> getBatches() {
        List<Batches> batches = batchesRepoService.toFindAll();
        if(batches.isEmpty()){
            throw new ResourceNotFoundException("No batches found");
        }
        List<BatchesDto> batchesDtoList = new ArrayList<>();
        for(Batches batches1:batches){
            batchesDtoList.add(convertToDto(batches1));
        }
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Batches are fetched successfully",batchesDtoList));
    }

    private BatchesDto convertToDto(Batches batches1) {
        BatchesDto batchesDto=modelMapper.map(batches1,BatchesDto.class);
        return batchesDto;
    }

    @Override
    public ResponseEntity<ResponseDto> getParticularBatch(Long id) {
        Optional<Batches> batches=batchesRepoService.toFindById(id);
        if(batches.isPresent()){
            BatchesDto batchesDto=modelMapper.map(batches,BatchesDto.class);
            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Batch for a particular id is fetched successfully",batchesDto));
        }
        throw new ResourceNotFoundException("Batch with id "+id+" does not found");
    }
}
