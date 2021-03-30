package cn.aguo.review.web.servlet;

import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.service.UserService;
import cn.aguo.review.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/28 下午8:23
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取生成的原始验证码值
        String checkcode = request.getSession().getAttribute("CHECKCODE_SERVER").toString();
        request.getSession().removeAttribute("CHECKCODE_SERVER");

        //获取浏览器请求的值
        Map<String, String[]> loginuser = request.getParameterMap();

        //将浏览器的请求值封装到Admin
        AdminUser au = new AdminUser();
        try {
            BeanUtils.populate(au,loginuser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (checkcode.equalsIgnoreCase(au.getChecknumber())){
            UserService us = new UserServiceImpl();
            if (us.loginAdmin(au)){
                request.getSession().setAttribute("admin",au);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                request.setAttribute("login_error","登陆失败，账号或者密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("login_error","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
