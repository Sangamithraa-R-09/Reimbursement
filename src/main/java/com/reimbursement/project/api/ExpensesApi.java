package com.reimbursement.project.api;

import com.reimbursement.project.dto.ExpenseIdDto;
import com.reimbursement.project.dto.ExpensesDto;
import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/expenses")
public interface ExpensesApi {
    @PostMapping
    public ResponseEntity<ResponseDto> storeExpenses(@RequestBody ExpensesDto expensesDto);

    @GetMapping("/expense_id/{id}")
    public ResponseEntity<ResponseDto> getExpenses(@PathVariable Long id);

    @PutMapping("/approve/travel_form_id/{id}")
    public ResponseEntity<ResponseDto> updateExpenses(@PathVariable Long id, @RequestBody ExpenseIdDto expenseIdDto);

    @GetMapping
    public ResponseEntity<ResponseDto> getAllExpenses(@RequestParam(name = "expenseStatus") String expenseStatus);

    @GetMapping("/expenses_count")
    public ResponseEntity<ResponseDto> getCount();



}
