package com.reimbursement.project.controller;

import com.reimbursement.project.api.TravelFormApi;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.service.TravelFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TravelFormController implements TravelFormApi {

    private final TravelFormService travelFormService;
    @Override
    public ResponseEntity<ResponseDto> getBillsStatusCount() {
        return travelFormService.getBillsStatusCount();
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelFormCount() {
        return travelFormService.getTravelFormStatusCount();
    }
}
