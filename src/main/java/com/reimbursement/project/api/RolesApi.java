package com.reimbursement.project.api;

import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.dto.RolesDto;
import com.reimbursement.project.entity.Roles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/roles")
public interface RolesApi {

    @PostMapping
    ResponseEntity<ResponseDto> postRoles(@RequestBody RolesDto rolesDto);
}
