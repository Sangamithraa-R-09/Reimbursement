package com.reimbursement.project.api;

import com.reimbursement.project.dto.BatchesRequestDto;
import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/batches")
public interface BatchesApi {

    @GetMapping("/filters")
    public ResponseEntity<ResponseDto> getExpensesByFilters(@RequestBody BatchesRequestDto batchesRequestDto);

    @GetMapping("/batches_history")
    public ResponseEntity<ResponseDto> getBatchHistory();

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getBatchesById(@PathVariable(name = "id") Long Id);

}
