package com.reimbursement.project.dto;

import com.reimbursement.project.entity.Expenses;
import com.reimbursement.project.entity.PurposeOfVisit;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelFormDto {
    private Long id;
    private Integer numberOfPeople;
    private String description;
    private List<ColleaguesDto> colleagueDetails;
}
