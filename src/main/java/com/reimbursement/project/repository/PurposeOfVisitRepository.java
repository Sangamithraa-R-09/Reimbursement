package com.reimbursement.project.repository;

import com.reimbursement.project.entity.PurposeOfVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeOfVisitRepository extends JpaRepository<PurposeOfVisit,Long> {
}
