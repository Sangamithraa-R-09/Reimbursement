package com.reimbursement.project.repository.service.impl;

import com.reimbursement.project.entity.Roles;
import com.reimbursement.project.repository.RolesRepository;
import com.reimbursement.project.repository.service.RolesRepoService;
import com.reimbursement.project.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesRepoServiceImpl implements RolesRepoService {

    private final RolesRepository rolesRepository;

    @Override
    public boolean isRoleExist(String roleName) {
        return true;
    }

    @Override
    public Roles toSave(Roles roles) {
        return rolesRepository.save(roles);
    }


}
