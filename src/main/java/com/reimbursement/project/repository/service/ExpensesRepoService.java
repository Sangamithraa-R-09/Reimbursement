package com.reimbursement.project.repository.service;

import com.reimbursement.project.entity.Enum.ExpenseStatus;
import com.reimbursement.project.entity.Expenses;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ExpensesRepoService {

    List<Map<String,Object>> expensesStatusCount();

    List<Expenses> expensesByStatus(ExpenseStatus expenseStatus);

    Expenses toSave(Expenses expenses);

    List<Expenses> toSaveAll(List<Expenses> expensesList);

    Optional<Expenses> toFindById(Long id);
}
