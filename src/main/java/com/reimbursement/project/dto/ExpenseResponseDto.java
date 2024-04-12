package com.reimbursement.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reimbursement.project.entity.Bills;
import com.reimbursement.project.entity.Enum.ExpenseStatus;
import com.reimbursement.project.entity.Expenses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDto{
    private Long id;

    private String expenseDescription;

    private Date expenseDate;

    private ExpenseTypeDto expenseType;

    private List<BillsDto> bills;

    private Float expenseAmount;

    private ExpenseStatus expenseStatus;
}
