package com.reimbursement.project.dto;

import com.reimbursement.project.entity.EmployeeDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchesRequestDto {
    private Date fromDate;
    private Date toDate;
    private String references;
    private EmployeeDetails employeeDetails;
}
