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

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/28 下午3:42
 */
@WebServlet("/echoUserServlet")
public class EchoUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        UserService us = new UserServiceImpl();
        User user = us.findId(id);

        request.setAttribute("echouser",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
