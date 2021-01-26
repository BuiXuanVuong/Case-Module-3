package com.mvc.service;

import com.mvc.model.BillModel;

import java.util.List;

public interface IBillService {
    BillModel findOne(Long id);
    BillModel save(BillModel billModel);
    List<BillModel> findAll();
    List<BillModel> findOrdersByUser(String userName);
}
