package com.mvc.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.model.BillModel;
import com.mvc.model.ProductModel;
import com.mvc.service.IBillService;
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

@WebServlet(urlPatterns = {"/web-product"})
public class BillAPI extends HttpServlet {

    @Inject
    private IBillService billService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
        System.out.println("------------------------Test");
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
//        BillModel billModel = HttpUtil.of(req.getReader()).toModel(BillModel.class);
        BillModel billModel = new BillModel();
        billModel.setProductName(req.getParameter("productName"));
        billModel.setAmount(Long.parseLong(req.getParameter("amount")));
        billModel.setProductPrice(Long.parseLong(req.getParameter("price")));
        billModel.setProductId(Long.parseLong(req.getParameter("productId")));
        billModel.setCustomerId(Long.parseLong(req.getParameter("customerId")));
        billModel.setCustomerName(req.getParameter("customerName"));
        billModel = billService.save(billModel);
        System.out.println("-----------------------------do post of web product------------------------");
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/success.jsp");
        rd.forward(req, resp);
//        mapper.writeValue(resp.getOutputStream(),billModel);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------do get of web product-----------------------------");
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/success.jsp");
        rd.forward(req, resp);

    }
}
