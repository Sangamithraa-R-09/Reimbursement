package com.reimbursement.project.repository.service.impl;

import com.reimbursement.project.entity.ExpenseType;
import com.reimbursement.project.repository.ExpenseTypeRepository;
import com.reimbursement.project.repository.service.ExpenseTypeRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseTypeRepoServiceImpl implements ExpenseTypeRepoService {

    private final ExpenseTypeRepository expenseTypeRepository;

    @Override
    public Optional<ExpenseType> toFindById(Long id) {
        return expenseTypeRepository.findById(id);
    }
}
