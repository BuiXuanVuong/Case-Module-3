package com.mvc.dao;

import com.mvc.model.BillModel;
import com.mvc.model.UserModel;

import java.util.List;

public interface IBillDAO extends GenericDAO<BillModel>{
    BillModel findOne(Long id);
    Long save(BillModel billModel);
    List<BillModel> findAll();
    List<BillModel> findOrdersByUser(String username);


}
