package com.mvc.controller.admin;

import com.mvc.model.ProductModel;
import com.mvc.service.impl.CategoryService;
import com.mvc.service.impl.ProductService;
import com.mvc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ProductModel model = FormUtil.toModel(ProductModel.class, req);
       String view = "";
       if( model.getType().equals("list")) {
           System.out.println("type = list");
           view = "/views/admin/new/list.jsp";
           model.setListResult(productService.findAll());
           req.setAttribute("categories",categoryService.findAll());
       } else if (model.getType().equals("edit")) {
           if (model.getId() != null) {
               model = productService.findOne(model.getId());
           } else {

           }
           req.setAttribute("categories", categoryService.findAll());
           view = "/views/admin/new/edit.jsp";
       } else if (model.getType().equals("delete")) {
           System.out.println("delete----");
           try {
               productService.delete(Long.parseLong(req.getParameter("id")));
           } catch (NumberFormatException e) {

           }
           view = "/views/admin/new/list.jsp";
           model.setListResult(productService.findAll());

       }
        req.setAttribute("model", model);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
