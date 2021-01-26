package com.mvc.mapper;

import com.mvc.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductMapper implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(ResultSet rs) {
        ProductModel product = new ProductModel();
        try {
            product.setId(rs.getLong("id"));
            product.setProductName(rs.getString("productname"));
            product.setCategoryId(rs.getLong("categoryid"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getLong("price"));
            product.setType(rs.getString("type"));
            product.setSpeed(rs.getLong("speed"));
            product.setPower(rs.getLong("power"));
            product.setGear(rs.getString("gear"));
            product.setLinkImage(rs.getString("linkimage"));
            return product;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
