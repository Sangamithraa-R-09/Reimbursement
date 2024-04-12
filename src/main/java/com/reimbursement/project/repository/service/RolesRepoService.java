package com.reimbursement.project.repository.service;

import com.reimbursement.project.entity.Roles;

public interface RolesRepoService {
    boolean isRoleExist(String roleName);

    Roles toSave(Roles roles);

}
