package com.mvc.dao.impl;

import com.mvc.dao.ICategoryDAO;
import com.mvc.mapper.CategoryMapper;
import com.mvc.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    public List<CategoryModel> findAll() {
        String sql = "select * from category";
        return query(sql,new CategoryMapper());
    }

    @Override
    public CategoryModel findOne(long id) {
        String sql = "SELECT * FROM category where id = ?";
        List<CategoryModel> category = query(sql, new CategoryMapper(), id);
        return  category.isEmpty()? null : category.get(0);
    }

    @Override
    public CategoryModel findOneByCode(String code) {
        String sql = "SELECT * FROM category where code = ?";
        List<CategoryModel> category = query(sql, new CategoryMapper(), code);
        return  category.isEmpty()? null : category.get(0);
    }
}
