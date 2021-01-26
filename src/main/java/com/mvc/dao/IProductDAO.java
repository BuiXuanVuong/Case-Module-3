package com.mvc.dao;

import com.mvc.model.ProductModel;

import java.util.List;

public interface IProductDAO extends GenericDAO<ProductModel>{
    ProductModel findOne(Long id);
    List<ProductModel> findByCategoryId(Long categoryId);
    Long save(ProductModel productModel);
    void update(ProductModel productModel);
    void delete(long id);
    List<ProductModel> findAll();
    List<ProductModel> findByName(String str);
    List<ProductModel> findByPrice(Long from, Long to);
    List<ProductModel> sortByPriceASC();
    List<ProductModel> sortByPriceDESC();
}
