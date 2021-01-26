package com.mvc.model;

import java.sql.Timestamp;

public class BillModel extends AbstractModel<BillModel> {
    private String productName;
    private String customerName;
    private Long productPrice;
    private Long customerId;
    private Long productId;
    private Long amount;
    private Timestamp timeBuy;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Timestamp getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(Timestamp timeBuy) {
        this.timeBuy = timeBuy;
    }
}
