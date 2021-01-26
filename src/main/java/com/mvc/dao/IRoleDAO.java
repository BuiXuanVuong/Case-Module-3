package com.mvc.dao;


import com.mvc.model.RoleModel;

import java.util.List;

public interface IRoleDAO {
    List<RoleModel> findAll();
}
