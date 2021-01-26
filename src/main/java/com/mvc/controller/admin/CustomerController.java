package com.mvc.controller.admin;

import com.mvc.model.UserModel;
import com.mvc.service.IRoleService;
import com.mvc.service.IUserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-listuser"})
public class CustomerController extends HttpServlet {

    @Inject
    IUserService userService;

    @Inject
    IRoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> listUser = userService.findAll();
        req.setAttribute("listuser", listUser);
        req.setAttribute("roles", roleService.findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/user/list.jsp");
        rd.forward(req, resp);
    }
}
