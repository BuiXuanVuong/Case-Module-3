package com.mvc.service.impl;

import com.mvc.dao.ICategoryDAO;
import com.mvc.dao.IProductDAO;
import com.mvc.model.ProductModel;
import com.mvc.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService {

    @Inject
    private IProductDAO productDAO;

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        return productDAO.findByCategoryId(categoryId);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        Long productId = productDAO.save(productModel);
        return productDAO.findOne(productId);
    }

    @Override
    public ProductModel update(ProductModel updateProduct) {
        productDAO.update(updateProduct);
        return  productDAO.findOne(updateProduct.getId());
    }

    @Override
    public void delete(long id) {
        productDAO.delete(id);
    }

    @Override
    public ProductModel findOne(long id) {
        ProductModel productModel = productDAO.findOne(id);
        return productModel;
    }

    @Override
    public List<ProductModel> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<ProductModel> findByName(String str) {
        return productDAO.findByName(str);
    }

    @Override
    public List<ProductModel> findByPrice(Long from, Long to) {
        return productDAO.findByPrice(from, to);
    }

    @Override
    public List<ProductModel> sortByPriceASC() {
        return productDAO.sortByPriceASC();
    }

    @Override
    public List<ProductModel> sortByPriceDESC() {
        return productDAO.sortByPriceDESC();
    }


}
