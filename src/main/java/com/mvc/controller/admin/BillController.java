package com.mvc.controller.admin;

import com.mvc.model.BillModel;
import com.mvc.service.IBillService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-listbill"})
public class BillController extends HttpServlet {

    @Inject
    IBillService billService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BillModel> billList = billService.findAll();
        req.setAttribute("billlist", billList);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/bill.jsp");
        rd.forward(req, resp);
    }
}
