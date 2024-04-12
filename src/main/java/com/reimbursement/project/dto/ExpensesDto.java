package com.reimbursement.project.dto;

import com.reimbursement.project.entity.TravelForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesDto {
    private TravelForm travelFormId;
    private List<ExpensesListDto> expensesList;
}
