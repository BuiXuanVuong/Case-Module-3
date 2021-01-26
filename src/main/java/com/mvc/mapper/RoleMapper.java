package com.mvc.mapper;

import com.mvc.model.CategoryModel;
import com.mvc.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet rs) {
        try {
            RoleModel role = new RoleModel();
            role.setId(rs.getLong("id"));
            role.setCode(rs.getString("code"));
            return role;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
