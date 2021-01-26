package com.mvc.service;

import com.mvc.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> findByCategoryId(Long categoryId);
    ProductModel save(ProductModel productModel);
    ProductModel update(ProductModel productModel);
    void delete(long id);
    ProductModel findOne(long id);
    List<ProductModel> findAll();
    List<ProductModel> findByName(String str);
    List<ProductModel> findByPrice(Long from, Long to);
    List<ProductModel> sortByPriceASC();
    List<ProductModel> sortByPriceDESC();
}
