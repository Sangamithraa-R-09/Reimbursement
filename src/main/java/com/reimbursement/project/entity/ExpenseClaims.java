package com.reimbursement.project.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reimbursement.project.entity.Enum.ExpenseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class ExpenseClaims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonDeserialize
    private ExpenseType expenseType;

    @ManyToOne
    private Managers managers;

    @OneToOne
    private Notification notification;

    @ManyToOne
    private Projects projects;

    @Column(name = "expenseDescription")
    private String expenseDescription;

    @Column(name = "expenseDate")
    private Date expenseDate;

    @OneToMany(mappedBy = "expenseClaims")
    private List<Bills> bills;

    @Column(name = "expenseAmount")
    private Float expenseAmount;

    private ExpenseStatus expenseStatus;

    @CreatedDate
    private java.util.Date createdAt;

    @LastModifiedDate
    private java.util.Date updatedAt;

    private java.util.Date deletedAt;
}
