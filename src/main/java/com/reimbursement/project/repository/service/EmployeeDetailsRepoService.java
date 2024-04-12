package com.reimbursement.project.repository.service;

import com.reimbursement.project.entity.EmployeeDetails;

import java.util.List;
import java.util.Map;

public interface EmployeeDetailsRepoService {
    List<Map<String,Object>> getColleagues();

    EmployeeDetails toFindByEmpId(Long empId);
}
