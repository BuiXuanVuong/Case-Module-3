package com.mvc.controller.web;

import com.mvc.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/detail")
public class DetailController extends HttpServlet {
    @Inject
    IProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "";
        String type = req.getParameter("type");
        Long id = Long.parseLong(req.getParameter("id")) ;
        if( type.equals("detail")) {
            view = "/views/web/detail.jsp";

        }
        req.setAttribute("product", productService.findOne(id));
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
