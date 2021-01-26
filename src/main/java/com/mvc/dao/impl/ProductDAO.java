package com.mvc.dao.impl;

import com.mvc.dao.IProductDAO;
import com.mvc.mapper.ProductMapper;
import com.mvc.model.ProductModel;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public ProductModel findOne(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<ProductModel> products = query(sql, new ProductMapper(), id);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM product WHERE categoryid = ?";
        return query(sql, new ProductMapper(), categoryId);
    }

    @Override
    public Long save(ProductModel productModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO product(productname,");
        sql.append(" categoryid, description, price, type, speed, power, gear, linkimage) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), productModel.getProductName(),productModel.getCategoryId(),
                productModel.getDescription(), productModel.getPrice(), productModel.getType(), productModel.getSpeed(), productModel.getPower(),
                productModel.getGear(), productModel.getLinkImage());
    }

    @Override
    public void update(ProductModel productModel) {
        StringBuilder sql = new StringBuilder("UPDATE product SET productname = ?, categoryid = ?,");
        sql.append(" description = ?,  price = ?, type = ?, speed = ?, power = ?, gear = ?,  linkimage = ? WHERE id = ?");
        update(sql.toString(), productModel.getProductName(), productModel.getCategoryId(),
                productModel.getDescription(), productModel.getPrice(),  productModel.getType(), productModel.getSpeed(), productModel.getPower(), productModel.getGear(),
                productModel.getLinkImage(), productModel.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<ProductModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM product");
        return query(sql.toString(), new ProductMapper());
    }

    @Override
    public List<ProductModel> findByName(String str) {
        String sql = "SELECT * FROM product WHERE productname LIKE ?";
        return query(sql, new ProductMapper(), str);
    }

    @Override
    public List<ProductModel> findByPrice(Long from, Long to) {
        StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE price between ? AND ? ORDER BY price ASC");
        return query(sql.toString(), new ProductMapper(), from, to);
    }

    @Override
    public List<ProductModel> sortByPriceASC() {
        StringBuilder sql = new StringBuilder("SELECT * FROM product ORDER BY price ASC");
        return query(sql.toString(), new ProductMapper());
    }

    @Override
    public List<ProductModel> sortByPriceDESC() {
        StringBuilder sql = new StringBuilder("SELECT * FROM product ORDER BY price DESC");
        return query(sql.toString(), new ProductMapper());
    }
}
