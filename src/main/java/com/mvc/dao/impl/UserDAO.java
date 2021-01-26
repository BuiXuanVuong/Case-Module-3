package com.mvc.dao.impl;

import com.mvc.dao.IUserDAO;
import com.mvc.mapper.UserMapper;
import com.mvc.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public UserModel findByUserNameAndPassword(String userName, String password) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE username = ? AND password = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<UserModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM user");
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public Long save(UserModel userModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO user(username, ");
        sql.append(" password, roleid, address, phone) VALUES(?, ?, ?, ?, ?)");
        return insert(sql.toString(), userModel.getUserName(), userModel.getPassword(), userModel.getRoleId(), userModel.getAddress(), userModel.getPhone());
    }
}
