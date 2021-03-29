package cn.aguo.review.web.servlet;

import cn.aguo.review.service.UserService;
import cn.aguo.review.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/28 上午10:28
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息，首先设置编码
        request.setCharacterEncoding("utf-8");

        //获取信息
        String id = request.getParameter("id");

        //执行删除方法
        UserService us = new UserServiceImpl();
        us.deleteUser(id);

        response.sendRedirect(request.getContextPath()+"/listUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
