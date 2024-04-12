package com.reimbursement.project.repository.service.impl;

import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.repository.EmployeeDetailsRepository;
import com.reimbursement.project.repository.service.EmployeeDetailsRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeDetailsRepoServiceImpl implements EmployeeDetailsRepoService {
    private final EmployeeDetailsRepository employeeDetailsRepository;
    @Override
    public List<Map<String, Object>> getColleagues() {
        return employeeDetailsRepository.findAllEmpIdAndName();
    }

    @Override
    public EmployeeDetails toFindByEmpId(Long empId) {
        return employeeDetailsRepository.findByEmpId(empId);
    }
}
