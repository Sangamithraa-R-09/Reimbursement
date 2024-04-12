package com.reimbursement.project.repository;

import com.reimbursement.project.entity.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long> {

    Optional<ExpenseType> findById(Long id);

}
