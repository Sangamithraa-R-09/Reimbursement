package com.reimbursement.project.controller;

import com.reimbursement.project.api.ExpensesApi;
import com.reimbursement.project.dto.ExpenseIdDto;
import com.reimbursement.project.dto.ExpensesDto;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.entity.Bills;
import com.reimbursement.project.entity.ExpenseType;
import com.reimbursement.project.entity.Expenses;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.repository.ExpenseTypeRepository;
import com.reimbursement.project.repository.ExpensesRepository;
import com.reimbursement.project.repository.TravelFormRepository;
import com.reimbursement.project.service.ExpensesService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExpensesController implements ExpensesApi {

    private final ExpensesService expensesService;


    @Override
    public ResponseEntity<ResponseDto> storeExpenses(ExpensesDto expensesDto) {
        return this.expensesService.storeExpenses(expensesDto);
    }

    @Override
    public ResponseEntity<ResponseDto> getExpenses(Long id) {
        return this.expensesService.getExpenses(id);
    }

    @Override
    public ResponseEntity<ResponseDto> updateExpenses(Long id, ExpenseIdDto expenseIdDto) {
        return this.expensesService.updateExpenses(id,expenseIdDto);
    }

    @Override
    public ResponseEntity<ResponseDto> getAllExpenses(String expenseStatus) {
        return this.expensesService.getAllExpenses(expenseStatus);
    }

    @Override
    public ResponseEntity<ResponseDto> getCount() {
        return this.expensesService.getExpensesCount();
    }

}
