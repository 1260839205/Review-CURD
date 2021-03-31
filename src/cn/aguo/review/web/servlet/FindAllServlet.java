package cn.aguo.review.web.servlet;

import cn.aguo.review.domain.User;
import cn.aguo.review.service.UserService;
import cn.aguo.review.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/31 下午3:07
 */
@WebServlet(name = "FindAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us = new UserServiceImpl();
        List<User> allUser = us.findAll();
        request.setAttribute("allUser",allUser);
        request.getRequestDispatcher("/add.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
