package com.reimbursement.project.controller;

import com.reimbursement.project.api.BatchesApi;
import com.reimbursement.project.dto.BatchesRequestDto;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.service.BatchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class BatchesController implements BatchesApi {

    private final BatchesService batchesService;

    @Override
    public ResponseEntity<ResponseDto> getExpensesByFilters(BatchesRequestDto batchesRequestDto) {
        return this.batchesService.createBatch(batchesRequestDto);
    }

    @Override
    public ResponseEntity<ResponseDto> getBatchHistory() {
        return batchesService.getBatches();
    }

    @Override
    public ResponseEntity<ResponseDto> getBatchesById(Long Id) {
        return batchesService.getParticularBatch(Id);
    }
}
