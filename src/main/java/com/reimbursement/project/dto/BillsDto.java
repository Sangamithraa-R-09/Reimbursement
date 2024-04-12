package com.reimbursement.project.dto;

import com.reimbursement.project.entity.Expenses;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillsDto {
    private String billsUrl;
    private String billType;
}
