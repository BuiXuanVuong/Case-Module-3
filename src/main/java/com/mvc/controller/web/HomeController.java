package com.mvc.controller.web;

import com.mvc.model.UserModel;
import com.mvc.service.ICategoryService;
import com.mvc.service.IUserService;
import com.mvc.service.impl.ProductService;
import com.mvc.utils.FormUtil;
import com.mvc.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/dang-ki","/thoat"})
public class HomeController extends HttpServlet {

    @Inject
    ProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String alert = request.getParameter("alert");
            String message = request.getParameter("message");

            if (message != null && alert != null) {
                request.setAttribute("message", resourceBundle.getString(message));
                request.setAttribute("alert", alert);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else if (action != null && action.equals("register")) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
            rd.forward(request, response);
        } else {
            if ((request.getParameter("sort")) != null) {
                Long sort =Long.parseLong(request.getParameter("sort"));
                request.setAttribute("categories", categoryService.findAll());
                request.setAttribute("listProduct", productService.findByCategoryId(sort));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request, response);
            } else if (request.getParameter("search") != null) {
                String search = request.getParameter("search");
                String search1 = "%"+search+"%";
                request.setAttribute("categories", categoryService.findAll());
                request.setAttribute("listProduct", productService.findByName(search1));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request, response);
            } else if (request.getParameter("from") != null) {
                Long from = Long.parseLong(request.getParameter("from"));
                Long to = Long.parseLong(request.getParameter("to"));
                request.setAttribute("categories", categoryService.findAll());
                request.setAttribute("listProduct", productService.findByPrice(from, to));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request, response);
            } else if (request.getParameter("price") != null) {
                String sort = request.getParameter("price");
                request.setAttribute("categories", categoryService.findAll());
                if(sort.equals("asc")) {
                    request.setAttribute("listProduct", productService.sortByPriceASC());
                } else {
                    request.setAttribute("listProduct", productService.sortByPriceDESC());
                }
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request, response);
            } else {

                request.setAttribute("categories", categoryService.findAll());
                request.setAttribute("listProduct", productService.findAll());
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel model = FormUtil.toModel(UserModel.class, request);
            model = userService.findByUserNameAndPassword(model.getUserName(), model.getPassword());
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                if (model.getRole().getCode().equals("USER")) {
                    response.sendRedirect(request.getContextPath()+"/trang-chu");
                } else if (model.getRole().getCode().equals("ADMIN")) {
                    response.sendRedirect(request.getContextPath()+"/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        } else if (action != null && action.equals("register")) {
            String account = request.getParameter("username");
            String checkPassword = request.getParameter("password");
            String checkPhone = request.getParameter("phone");
            boolean regexPassword = Pattern.matches("((?=.*\\d)(?=.*[a-z]).{6,20})",checkPassword);
            boolean regexPhone = Pattern.matches("([0-9]{10,11})",checkPhone);

            List<UserModel> users = userService.findAll();
            boolean accountExists = false;

            System.out.println("regex " +regexPassword);
            System.out.println("regex " +regexPhone);

            if (!(regexPassword && regexPhone)) {
                request.setAttribute("alert","Mật khẩu hoặc số điện thoại không đúng định dạng!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
                rd.forward(request, response);
               return;
            }

            for (UserModel user: users) {
                if (user.getUserName().equals(account)) {
                    request.setAttribute("notify", "Tài khoản hiện đã tồn tại!");
                    accountExists = true;
                    RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
                    rd.forward(request, response);
                }
            }

            if (!accountExists) {
                String name = request.getParameter("username");
                String password = request.getParameter("password");
                Long roleid = Long.parseLong(request.getParameter("roleid"));
                String address = request.getParameter("address");
                Long phone = Long.parseLong(request.getParameter("phone"));
                UserModel userModel = new UserModel();
                userModel.setUserName(name);
                userModel.setPassword(password);
                userModel.setAddress(address);
                userModel.setPhone(phone);
                userModel.setRoleId(roleid);
                userService.save(userModel);
                request.setAttribute("success", "Bạn đã đăng kí thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
                rd.forward(request, response);
            }
        }
    }
}


