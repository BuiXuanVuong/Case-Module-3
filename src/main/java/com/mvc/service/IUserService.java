package com.mvc.service;

import com.mvc.model.ProductModel;
import com.mvc.model.UserModel;

import java.util.List;

public interface IUserService {
    UserModel findByUserNameAndPassword(String userName, String password);
    List<UserModel> findAll();
    void save(UserModel userModel);
}
