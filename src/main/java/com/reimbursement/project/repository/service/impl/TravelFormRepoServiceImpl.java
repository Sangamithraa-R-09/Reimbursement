package com.reimbursement.project.repository.service.impl;

import com.reimbursement.project.dto.TravelFormDto;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.repository.TravelFormRepository;
import com.reimbursement.project.repository.service.TravelFormRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelFormRepoServiceImpl implements TravelFormRepoService {

    private final TravelFormRepository travelFormRepository;
    @Override
    public List<TravelForm> filters(Date fromDate, Date toDate, String firstName, Long empId) {
        return travelFormRepository.findByEmployee_EmpIdAndApplyDateBetweenAndEmployee_FirstName(empId,fromDate,toDate,firstName);
    }

    @Override
    public List<Map<String, Object>> travelFormStatusCount() {
        return travelFormRepository.getTravelFormStatusCounts();
    }

    @Override
    public List<Map<String, Object>> billsStatusCount() {
        return travelFormRepository.getBillsStatusCount();
    }

    @Override
    public List<Map<String, Object>> saveDate() {
        return null;
    }

    @Override
    public Optional<TravelForm> toFindById(Long id) {
        return travelFormRepository.findById(id);
    }

    @Override
    public TravelForm toSave(TravelForm travelForm) {
        return travelFormRepository.save(travelForm);
    }


}
