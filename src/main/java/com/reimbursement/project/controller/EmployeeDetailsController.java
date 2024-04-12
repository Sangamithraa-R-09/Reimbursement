package com.reimbursement.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.project.api.EmployeeDetailsApi;
import com.reimbursement.project.dto.EmployeeDetailsDto;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.dto.TravelFormDto;
import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.repository.TravelFormRepository;
import com.reimbursement.project.service.EmployeeDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeDetailsController implements EmployeeDetailsApi {

    private final EmployeeDetailsService employeeDetailsService;

    @Override
    public ResponseEntity<ResponseDto> getColleagues() {
        return employeeDetailsService.getColleaguesInfo();
    }

}
