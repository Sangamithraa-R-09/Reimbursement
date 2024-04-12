package com.reimbursement.project.repository.service;

import com.reimbursement.project.dto.TravelFormDto;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.repository.TravelFormRepository;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TravelFormRepoService {
    List<TravelForm> filters(Date fromDate,Date toDate, String firstName, Long empId);

    List<Map<String,Object>> travelFormStatusCount();

    List<Map<String,Object>> billsStatusCount();

    List<Map<String,Object>> saveDate();

    Optional<TravelForm> toFindById(Long id);

    TravelForm toSave(TravelForm travelForm);

}
