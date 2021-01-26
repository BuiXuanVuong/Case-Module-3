package com.mvc.dao.impl;

import com.mvc.dao.IBillDAO;
import com.mvc.mapper.BillMapper;
import com.mvc.model.BillModel;
import com.mvc.model.UserModel;

import java.util.List;

public class BillDAO extends AbstractDAO<BillModel> implements IBillDAO {
    @Override
    public BillModel findOne(Long id) {
        String sql = "SELECT * FROM bill WHERE id = ?";
        List<BillModel> bills = query(sql, new BillMapper(), id);
        return bills.isEmpty() ? null : bills.get(0);
    }

    @Override
    public Long save(BillModel billModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO bill(customername, productname, productprice, customerid,");
        sql.append(" productid, amount, timebuy) VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(),billModel.getCustomerName(),billModel.getProductName(),billModel.getProductPrice(), billModel.getCustomerId(),billModel.getProductId(),
                billModel.getAmount(), billModel.getTimeBuy());
    }

    @Override
    public List<BillModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM bill ORDER BY timebuy DESC ");
        return query(sql.toString(),new BillMapper());
    }

    @Override
    public List<BillModel> findOrdersByUser(String userName) {
        StringBuilder sql = new StringBuilder("SELECT * FROM bill WHERE customername = ? ORDER BY timebuy DESC");
        return query(sql.toString(), new BillMapper(), userName);
    }
}
