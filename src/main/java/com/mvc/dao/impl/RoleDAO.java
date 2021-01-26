package com.mvc.dao.impl;

import com.mvc.dao.IRoleDAO;
import com.mvc.mapper.CategoryMapper;
import com.mvc.mapper.RoleMapper;
import com.mvc.model.CategoryModel;
import com.mvc.model.RoleModel;

import java.util.List;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public List<RoleModel> findAll() {
        String sql = "select * from role";
        return query(sql,new RoleMapper());
    }
}
