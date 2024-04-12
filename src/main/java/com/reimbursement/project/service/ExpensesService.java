package com.reimbursement.project.service;

import com.reimbursement.project.dto.ExpenseIdDto;
import com.reimbursement.project.dto.ExpensesDto;
import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ExpensesService {

    public ResponseEntity<ResponseDto> storeExpenses(ExpensesDto expensesDto);

    public ResponseEntity<ResponseDto> getExpenses(Long id);

    public ResponseEntity<ResponseDto> updateExpenses(Long id, ExpenseIdDto expenseIdDto);

    public ResponseEntity<ResponseDto> getAllExpenses(String expenseStatus);

    public ResponseEntity<ResponseDto> getExpensesCount();
}
