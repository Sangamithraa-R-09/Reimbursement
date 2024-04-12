package com.reimbursement.project.repository.service.impl;

import com.reimbursement.project.entity.Enum.ExpenseStatus;
import com.reimbursement.project.entity.Expenses;
import com.reimbursement.project.repository.ExpensesRepository;
import com.reimbursement.project.repository.service.ExpensesRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpensesRepoServiceImpl implements ExpensesRepoService {

    private final ExpensesRepository expensesRepository;

    @Override
    public List<Map<String, Object>> expensesStatusCount() {
        return expensesRepository.getExpensesStatusCount();
    }

    @Override
    public List<Expenses> expensesByStatus(ExpenseStatus expenseStatus) {
        return expensesRepository.findByExpenseStatus(expenseStatus);
    }

    @Override
    public Expenses toSave(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> toSaveAll(List<Expenses> expensesList) {
        return expensesRepository.saveAll(expensesList);
    }

    @Override
    public Optional<Expenses> toFindById(Long id) {
        return expensesRepository.findById(id);
    }
}
