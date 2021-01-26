package com.mvc.controller.web;

import com.mvc.model.BillModel;
import com.mvc.model.ProductModel;
import com.mvc.service.impl.BillService;
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
import java.util.List;

@WebServlet(urlPatterns = {"/bill"})
public class BillController extends HttpServlet {

    @Inject
    private BillService billService;

    @Inject
    private ProductService productService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String view = "";
       String type = req.getParameter("type");

       if (req.getParameter("id") != null) {
           Long id = Long.parseLong(req.getParameter("id")) ;
           if( type.equals("order")) {
               view = "/bill/billAAA.jsp";
           }
           req.setAttribute("product", productService.findOne(id));
           RequestDispatcher rd = req.getRequestDispatcher(view);
           rd.forward(req, resp);
       } else if (req.getParameter("orders") != null) {
            String username = req.getParameter("orders");
            List<BillModel> listProductByUser = billService.findOrdersByUser(username);
            req.setAttribute("listproductbyuser", listProductByUser);
            RequestDispatcher rd1 = req.getRequestDispatcher("/views/web/bill.jsp");
            rd1.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
