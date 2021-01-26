package com.mvc.service.impl;

import com.mvc.dao.IRoleDAO;
import com.mvc.model.RoleModel;
import com.mvc.service.IRoleService;

import javax.inject.Inject;
import java.util.List;

public class RoleService implements IRoleService {

    @Inject
    IRoleDAO roleDAO;

    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }
}
