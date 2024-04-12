package com.reimbursement.project.service.impl;

import com.reimbursement.project.dto.*;
import com.reimbursement.project.entity.*;
import com.reimbursement.project.entity.Enum.BillStatus;
import com.reimbursement.project.entity.Enum.ExpenseStatus;
import com.reimbursement.project.entity.Enum.NotifyStatus;
import com.reimbursement.project.entity.Enum.TravelFormStatus;
import com.reimbursement.project.exception.AlreadyExistException;
import com.reimbursement.project.exception.InvalidException;
import com.reimbursement.project.exception.ResourceNotFoundException;
import com.reimbursement.project.repository.*;
import com.reimbursement.project.repository.service.*;
import com.reimbursement.project.service.ExpensesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.reimbursement.project.entity.Bills;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesRepoService expensesRepoService;
    private final TravelFormRepoService travelFormRepoService;
    private final NotificationRepoService notificationRepoService;
    private final ExpenseTypeRepoService expenseTypeRepoService;
    private final BillsRepoService billsRepoService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public ResponseEntity<ResponseDto> storeExpenses(ExpensesDto expensesDto) {

            Optional<TravelForm> travelForm = travelFormRepoService.toFindById(expensesDto.getTravelFormId().getId());
            if(travelForm.isPresent()){
                TravelForm travelForm1=travelForm.get();
                if(travelForm1.getTravelFormStatus().equals(TravelFormStatus.APPROVED)){
                    if(travelForm1.getBillStatus().equals(BillStatus.NO_BILL)){

                        Notification notification=new Notification();
                        notification.setAdminNotificationStatus(String.valueOf(NotifyStatus.SENT));
                        notification.setManagerNotificationStatus(String.valueOf(NotifyStatus.SENT));
                        notification.setFormType("Expenses");
                        notification.setEmpId(travelForm1.getEmployee().getId());
                        notification.setManagerId(travelForm1.getManagers().getId());
                        Date date=new Date();
                        notification.setDate(date);
                        notificationRepoService.toSave(notification);

                        List<ExpensesListDto> expensesListDtos=expensesDto.getExpensesList();
                        if(expensesListDtos!=null){
                            List<Expenses> expensesList=expensesListDtos
                                    .stream()
                                    .map(expensesListDto -> {
                                        Expenses expenses1=new Expenses();
                                        expenses1.setTravelForm(expensesDto.getTravelFormId());

                                        ExpenseType expenseType1=expenseTypeRepoService.toFindById(expensesListDto.getExpenseType()).get();
                                        expenses1.setExpenseType(expenseType1);

                                        expenses1.setExpenseDescription(expensesListDto.getExpenseDescription());
                                        expenses1.setExpenseDate(expensesListDto.getExpenseDate());
                                        expenses1.setExpenseAmount(expensesListDto.getExpenseAmount());
                                        expenses1.setExpenseStatus(ExpenseStatus.PENDING);

                                        Notification notification1=notificationRepoService.toFindById(notification.getId()).get();
                                        expenses1.setNotification(notification1);

                                        return expenses1;
                                    }).collect(Collectors.toList());
                            List<Expenses> savedExpenses=expensesRepoService.toSaveAll(expensesList);

                            for (int i = 0; i < savedExpenses.size(); i++) {
                                Expenses savedExpense = savedExpenses.get(i);
                                ExpensesListDto expensesListDto = expensesListDtos.get(i);

                                List<BillsDto> billsDto = expensesListDto.getBills();
                                if (billsDto != null) {
                                    List<Bills> bills = billsDto.stream()
                                            .map(billsDto1 -> {
                                                Bills bills1 = new Bills();
                                                bills1.setBillsUrl(billsDto1.getBillsUrl());
                                                bills1.setBillType(billsDto1.getBillType());
                                                bills1.setExpenses(savedExpense);
                                                return bills1;
                                            }).toList();
                                    billsRepoService.toSaveAll(bills);
                                }
                            }
                            travelForm1.setBillStatus(BillStatus.BILL_ADDED);
                            travelFormRepoService.toSave(travelForm1);

                            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Expenses saved successfully",savedExpenses));

                        }
                        throw new ResourceNotFoundException("Expenses are not found");
                    }
                    throw new AlreadyExistException("Bills are already added to this travel form");

                }
                throw new InvalidException("Such travel form is not yet approved");

            }
            throw new ResourceNotFoundException("No such travel form exists");
    }


    @Override
    public ResponseEntity<ResponseDto> getExpenses(Long id) {
        Optional<Expenses> expenses=expensesRepoService.toFindById(id);
        if(expenses.isPresent()){
            ExpenseResponseDto expenseResponseDto=modelMapper.map(expenses,ExpenseResponseDto.class);
            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Expenses are fetched successfully",expenseResponseDto));
        }
    throw new ResourceNotFoundException("Expense with id " +id+" could not be found");
    }

    @Override
    public ResponseEntity<ResponseDto> updateExpenses(Long id, ExpenseIdDto expenseIdDto) {
        Optional<TravelForm> travelForm=travelFormRepoService.toFindById(id);
        if(travelForm.isPresent()){
            TravelForm travelForm1=travelForm.get();
            Optional<Expenses> expenses = expensesRepoService.toFindById(expenseIdDto.getId());
            if(expenses.isPresent() && expenses.get().getTravelForm().getId().equals(id)){
                Expenses expenses1=expenses.get();
                ExpenseStatus expenseStatus=ExpenseStatus.valueOf(expenseIdDto.getExpenseStatus().toUpperCase());
                expenses1.setExpenseStatus(expenseStatus);
                expensesRepoService.toSave(expenses1);
                ExpenseIdDto expenseIdDto1=modelMapper.map(expenses1,ExpenseIdDto.class);
                return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Status updated successfully",expenseIdDto1));
            }
            throw new ResourceNotFoundException("Expense with id "+expenseIdDto.getId()+" could not be found for the given travel form Id");
        }
        throw new ResourceNotFoundException("TravelForm with id "+id+" could not be found");
    }


    @Override
    public ResponseEntity<ResponseDto> getAllExpenses(String expenseStatus) {
        ExpenseStatus expenseStatus1=ExpenseStatus.valueOf(expenseStatus.toUpperCase());
        List<Expenses> expenses = expensesRepoService.expensesByStatus(expenseStatus1);
        if (expenses.isEmpty()){
            throw new ResourceNotFoundException("No expenses are found");
        }
        List<ExpenseResponseDto> expenseResponseDtoList=new ArrayList<>();
        for(Expenses expenses1:expenses){
            expenseResponseDtoList.add(convertToDto(expenses1));
        }

        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Expenses fetched successfully",expenseResponseDtoList));
    }

    private ExpenseResponseDto convertToDto(Expenses expenses1) {
        ExpenseResponseDto expenseResponseDto=modelMapper.map(expenses1,ExpenseResponseDto.class);
        return expenseResponseDto;
    }

    @Override
    public ResponseEntity<ResponseDto> getExpensesCount() {
        List<Map<String,Object>> expensesStatusCount =  expensesRepoService.expensesStatusCount();
        List<Map<String,Object>> countOfExpenses=new ArrayList<>();
        for(Map<String,Object> expenses:expensesStatusCount){
            Map<String,Object> newExpense= new HashMap<>(Map.copyOf(expenses));
            short status = (short) expenses.get("expense_status");
            switch (status){
                case 0:
                    newExpense.put("expense_status",ExpenseStatus.PENDING);
                    break;
                case 1:
                    newExpense.put("expense_status",ExpenseStatus.MANAGER_APPROVED);
                    break;
                case 2:
                    newExpense.put("expense_status",ExpenseStatus.MANAGER_REJECTED);
                    break;
                case 3:
                    newExpense.put("expense_status",ExpenseStatus.ADMIN_APPROVED);
                    break;
                case 4:
                    newExpense.put("expense_status",ExpenseStatus.ADMIN_REJECTED);
                default:
                    break;
            }
            countOfExpenses.add(newExpense);
        }
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Expenses count fetched successfully",countOfExpenses));
    }


}
