package com.reimbursement.project.service.impl;

import com.reimbursement.project.api.EmployeeDetailsApi;
import com.reimbursement.project.dto.ColleaguesDto;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.exception.ResourceNotFoundException;
import com.reimbursement.project.repository.EmployeeDetailsRepository;
import com.reimbursement.project.repository.service.EmployeeDetailsRepoService;
import com.reimbursement.project.service.EmployeeDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    private final EmployeeDetailsRepoService employeeDetailsRepoService;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<ResponseDto> getColleaguesInfo() {
        List<Map<String,Object>> employeeDetails = employeeDetailsRepoService.getColleagues();
        if(employeeDetails!=null){
            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Colleague details are fetched successfully",employeeDetails));
        }
        throw new ResourceNotFoundException("No colleague details found");
    }

}
