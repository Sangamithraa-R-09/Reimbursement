package com.reimbursement.project.repository;

import com.reimbursement.project.entity.Batches;
import com.reimbursement.project.entity.EmployeeDetails;
import com.reimbursement.project.entity.TravelForm;
import com.reimbursement.project.repository.service.BatchesRepoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BatchesRepository extends JpaRepository<Batches,Long> {

    Batches save(Batches batches);

    Optional<Batches> findById(Long id);

    List<Batches> findAll();

}
