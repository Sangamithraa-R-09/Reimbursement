package com.reimbursement.project.service.impl;

import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.entity.Enum.BillStatus;
import com.reimbursement.project.repository.TravelFormRepository;
import com.reimbursement.project.repository.service.TravelFormRepoService;
import com.reimbursement.project.service.TravelFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TravelFormServiceImpl implements TravelFormService {

    private final TravelFormRepoService travelFormRepoService;

    @Override
    public ResponseEntity<ResponseDto> getBillsStatusCount() {
        List<Map<String,Object>> billStatusCount = travelFormRepoService.billsStatusCount();
        List<Map<String,Object>> countOfBills=new ArrayList<>();
        for(Map<String,Object> bill:billStatusCount){
            Map<String,Object> newBill= new HashMap<>(Map.copyOf(bill));
            short status = (short) bill.get("bill_status");
            switch (status){
                case 0:
                    newBill.put("bill_status",BillStatus.NO_BILL);
                    break;
                case 1:
                    newBill.put("bill_status",BillStatus.BILL_ADDED);
                    break;
                case 2:
                    newBill.put("bill_status",BillStatus.BILL_APPROVED);
                    break;
                case 3:
                    newBill.put("bill_status",BillStatus.BILL_REJECTED);
                    break;
                default:
                    break;
            }
            countOfBills.add(newBill);
        }
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Bills Count are fetched successfully",countOfBills));
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelFormStatusCount() {
        List<Map<String,Object>> travelFromStatusCount = travelFormRepoService.travelFormStatusCount();
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"TravelForm status count are fetched successfully",travelFromStatusCount));
    }
}


