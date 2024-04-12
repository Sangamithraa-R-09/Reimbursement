package com.reimbursement.project.controller;

import com.reimbursement.project.api.RolesApi;
import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.dto.RolesDto;
import com.reimbursement.project.entity.Roles;
import com.reimbursement.project.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RolesController implements RolesApi {

    private final RolesService rolesService;
    @Override
    public ResponseEntity<ResponseDto> postRoles(RolesDto rolesDto) {
        return rolesService.postRoles(rolesDto);
    }
}
