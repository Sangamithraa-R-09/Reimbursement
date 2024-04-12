package com.reimbursement.project.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchesDto {
    private Long id;
    private Date date;
    private Date fromDate;
    private Date toDate;
    private String reference;
}
