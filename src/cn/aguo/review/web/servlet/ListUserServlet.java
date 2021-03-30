package cn.aguo.review.web.servlet;

import cn.aguo.review.domain.PageBean;
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

        //2.接收当前页码和每页展示数量
        String _currentPageNumber = request.getParameter("currentPageNumber");
        String _rows = request.getParameter("rows");

        if ("".equals(_currentPageNumber) || _currentPageNumber == null){
            _currentPageNumber = "1";
            _rows = "5";
        }

        //3.每页展示查询
        UserService us = new UserServiceImpl();
        PageBean<User> pbu = us.findUserByPage(_currentPageNumber,_rows);

        //存储到request域中
        request.setAttribute("pbu",pbu);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
