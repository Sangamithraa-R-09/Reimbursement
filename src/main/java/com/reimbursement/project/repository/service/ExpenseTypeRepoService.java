package com.reimbursement.project.repository.service;

import com.reimbursement.project.entity.ExpenseType;
import com.reimbursement.project.repository.ExpenseTypeRepository;

import java.awt.font.OpenType;
import java.util.Optional;

public interface ExpenseTypeRepoService {

    Optional<ExpenseType> toFindById(Long id);
}
