package com.reimbursement.project.service;

import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TravelFormService {

    public ResponseEntity<ResponseDto> getBillsStatusCount();

    public ResponseEntity<ResponseDto> getTravelFormStatusCount();
}
