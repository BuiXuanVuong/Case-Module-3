package com.mvc.mapper;

import com.mvc.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        try {
            CategoryModel category = new CategoryModel();
            category.setId(rs.getLong("id"));
            category.setCode(rs.getString("code"));
            return category;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
