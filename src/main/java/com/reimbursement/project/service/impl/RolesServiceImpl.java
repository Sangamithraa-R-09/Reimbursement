package com.reimbursement.project.service.impl;

import com.reimbursement.project.dto.ResponseDto;
import com.reimbursement.project.dto.RolesDto;
import com.reimbursement.project.entity.Roles;
import com.reimbursement.project.exception.AlreadyExistException;
import com.reimbursement.project.repository.RolesRepository;
import com.reimbursement.project.repository.service.RolesRepoService;
import com.reimbursement.project.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepoService rolesRepoService;

    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<ResponseDto> postRoles(RolesDto roles) {
        if(rolesRepoService.isRoleExist(roles.getRoleName())) {
            throw new AlreadyExistException("The role "+roles.getRoleName()+" already exists");
        }
        Roles roles1=modelMapper.map(roles,Roles.class);
        rolesRepoService.toSave(roles1);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Roles are added successfully",roles));
    }

}
