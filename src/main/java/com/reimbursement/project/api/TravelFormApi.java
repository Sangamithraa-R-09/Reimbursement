package com.reimbursement.project.api;

import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/travelForm")
public interface TravelFormApi {

    @GetMapping("/bills_count")
    public ResponseEntity<ResponseDto> getBillsStatusCount();

    @GetMapping("/travel_form_count")
    public ResponseEntity<ResponseDto> getTravelFormCount();
}