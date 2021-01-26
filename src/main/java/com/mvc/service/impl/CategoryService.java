package com.mvc.service.impl;

import com.mvc.dao.ICategoryDAO;
import com.mvc.model.CategoryModel;
import com.mvc.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
