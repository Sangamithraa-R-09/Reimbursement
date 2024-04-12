package com.reimbursement.project.service;

import com.reimbursement.project.dto.BatchesRequestDto;
import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface BatchesService {
    public ResponseEntity<ResponseDto> createBatch(BatchesRequestDto batchesRequestDto);

    public ResponseEntity<ResponseDto> getBatches();

    public ResponseEntity<ResponseDto> getParticularBatch(Long id);

}
