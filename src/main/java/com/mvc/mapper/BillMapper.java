package com.mvc.mapper;

import com.mvc.model.BillModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<BillModel>{
    @Override
    public BillModel mapRow(ResultSet rs) {

        try {
            BillModel billModel = new BillModel();
            billModel.setId(rs.getLong("id"));
            billModel.setCustomerName(rs.getString("customername"));
            billModel.setProductName(rs.getString("productname"));
            billModel.setProductPrice(rs.getLong("productprice"));
            billModel.setCustomerId(rs.getLong("customerid"));
            billModel.setProductId(rs.getLong("productid"));
            billModel.setAmount(rs.getLong("amount"));
            billModel.setTimeBuy(rs.getTimestamp("timebuy"));
            return billModel;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
