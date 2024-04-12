package com.reimbursement.project.repository;

import com.reimbursement.project.entity.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsRepository extends JpaRepository<Bills,Long> {

    //List<Bills> saveAll(List<Bills> bills);
}
