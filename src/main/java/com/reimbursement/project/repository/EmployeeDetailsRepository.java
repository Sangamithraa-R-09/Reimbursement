package com.reimbursement.project.repository;

import com.reimbursement.project.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {
    @Query("SELECT e.empId AS empId, e.firstName AS firstName FROM EmployeeDetails e")
    List<Map<String,Object>> findAllEmpIdAndName();

    EmployeeDetails findByEmpId(Long empId);
}
