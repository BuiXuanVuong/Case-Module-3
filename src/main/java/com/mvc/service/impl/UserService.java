package com.mvc.service.impl;

import com.mvc.dao.IUserDAO;
import com.mvc.model.UserModel;
import com.mvc.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findByUserNameAndPassword(String userName, String password) {
        return userDAO.findByUserNameAndPassword(userName, password);
    }

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(UserModel userModel) {
        userDAO.save(userModel);
    }
}
