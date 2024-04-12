package com.reimbursement.project.repository;

import com.reimbursement.project.dto.ExpenseTypeDto;
import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.entity.ExpenseType;
import com.reimbursement.project.entity.TravelForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface TravelFormRepository extends JpaRepository<TravelForm,Long> {
    List<TravelForm> findByEmployee_EmpIdAndApplyDateBetweenAndEmployee_FirstName(Long empId,Date fromDate, Date toDate, String firstName);

    @Query(value = "SELECT travel_form.travel_form_status, COUNT(*) as travel_form_status_count FROM travel_form GROUP BY travel_form.travel_form_status", nativeQuery = true)
    List<Map<String,Object>> getTravelFormStatusCounts();

    @Query(value= "SELECT travel_form.bill_status, COUNT(*) as bill_status_count FROM travel_form GROUP BY travel_form.bill_status", nativeQuery = true)
    List<Map<String,Object>> getBillsStatusCount();

    Optional<TravelForm> findById(Long id);

    TravelForm save(TravelForm travelForm);


}
