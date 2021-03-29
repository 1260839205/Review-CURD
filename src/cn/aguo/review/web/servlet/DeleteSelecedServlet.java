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
 * @Date 2021/3/28 下午2:38
 */
@WebServlet("/deleteSelecedServlet")
public class DeleteSelecedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取所有成员编号
        String[] uids = request.getParameterValues("uid");

        //调用方法删除批量数据
        UserService us = new UserServiceImpl();
        us.delSelecedUser(uids);

        //删除成功,页面跳转
        response.sendRedirect(request.getContextPath()+"/listUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
