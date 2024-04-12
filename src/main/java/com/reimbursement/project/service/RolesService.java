package com.reimbursement.project.service;

import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.dto.RolesDto;
import com.reimbursement.project.entity.Roles;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RolesService {

    public ResponseEntity<ResponseDto> postRoles(RolesDto rolesDto);
}
