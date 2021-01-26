package com.mvc.service.impl;

import com.mvc.dao.IBillDAO;
import com.mvc.model.BillModel;
import com.mvc.service.IBillService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class BillService implements IBillService {

    @Inject
    IBillDAO billDAO;

    @Override
    public BillModel findOne(Long id) {
        return null;
    }

    @Override
    public BillModel save(BillModel billModel) {
        billModel.setTimeBuy(new Timestamp(System.currentTimeMillis()));
        Long billId = billDAO.save(billModel);
        return billDAO.findOne(billId);
    }

    @Override
    public List<BillModel> findAll() {
        return billDAO.findAll();
    }

    @Override
    public List<BillModel> findOrdersByUser(String userName) {
        return billDAO.findOrdersByUser(userName);
    }
}
