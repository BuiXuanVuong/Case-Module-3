package com.mvc.dao;

import com.mvc.model.ProductModel;
import com.mvc.model.UserModel;

import java.util.List;

public interface IUserDAO {
    UserModel findByUserNameAndPassword(String userName, String password);
    List<UserModel> findAll();
    Long save(UserModel userModel);
}
