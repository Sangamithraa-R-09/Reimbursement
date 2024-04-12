package com.reimbursement.project.api;

import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.entity.EmployeeDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
public interface EmployeeDetailsApi {

    @GetMapping("/colleagues")
    public ResponseEntity<ResponseDto> getColleagues();
}
