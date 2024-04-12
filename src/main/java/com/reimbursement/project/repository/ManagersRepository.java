package com.reimbursement.project.repository;

import com.reimbursement.project.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagersRepository extends JpaRepository<Managers,Long> {
}
