package com.reimbursement.project.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.reimbursement.project.entity.Enum.BillStatus;
import com.reimbursement.project.entity.Enum.TravelFormStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_form")
@EntityListeners(AuditingEntityListener.class)
public class TravelForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private EmployeeDetails employee;

    @ManyToOne
    private Managers managers;

    @ManyToOne
    private Projects project;

    private Integer numberOfPeople;

    @OneToMany(mappedBy = "travelForm")
    @JsonIgnore
    private List<Expenses> expenses;

    @ManyToOne
    private PurposeOfVisit purposeOfVisit;

    private String description;

    private Date applyDate;

    private Date travelDate;

    private BillStatus billStatus;

    private String remarks;

    private TravelFormStatus travelFormStatus;

    @Column(columnDefinition = "JSON")
    private String colleagueDetails;

    @JsonCreator
    public TravelForm(@JsonProperty("colleagueDetails") String colleagueDetails) {
    this.colleagueDetails = colleagueDetails;
}

    @OneToOne
    private Notification notification;

    @ManyToOne
    @JsonIgnore
    private Batches batch;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    private Date deletedAt;
}


