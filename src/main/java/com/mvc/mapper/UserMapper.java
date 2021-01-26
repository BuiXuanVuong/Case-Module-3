package com.mvc.mapper;

import com.mvc.model.RoleModel;
import com.mvc.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel>{
    @Override
    public UserModel mapRow(ResultSet rs) {
        try {
            UserModel user = new UserModel();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getLong("roleid"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getLong("phone"));
            try {
                RoleModel role = new RoleModel();
                role.setId(rs.getLong("id"));
                role.setCode(rs.getString("code"));
                user.setRole(role);
            } catch (Exception e) {

            }
            return user;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
