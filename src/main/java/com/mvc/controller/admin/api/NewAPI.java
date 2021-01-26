package com.mvc.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.model.ProductModel;
import com.mvc.service.IProductService;
import com.mvc.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        productModel = productService.save(productModel);
        resp.sendRedirect(req.getContextPath()+"/admin-home");
        mapper.writeValue(resp.getOutputStream(),productModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel updateProduct = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        updateProduct = productService.update(updateProduct);
        mapper.writeValue(resp.getOutputStream(), updateProduct);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.delete(productModel.getId());
        mapper.writeValue(resp.getOutputStream(),"{}");
    }
}
