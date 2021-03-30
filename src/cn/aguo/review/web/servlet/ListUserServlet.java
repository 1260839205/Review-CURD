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
 * @Date 2021/3/27 下午4:40
 */
@WebServlet("/listUserServlet")
public class ListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
