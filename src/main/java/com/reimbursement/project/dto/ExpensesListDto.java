package com.reimbursement.project.dto;

import com.reimbursement.project.entity.Bills;
import com.reimbursement.project.entity.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesListDto {
        private Long expenseType;
        private String expenseDescription;
        private Date expenseDate;
        private Float expenseAmount;
        private List<BillsDto> bills;
    }

