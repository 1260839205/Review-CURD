package cn.aguo.review.web.filter;

import cn.aguo.review.domain.AdminUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/30 下午8:51
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取浏览器请求访问路径
        String URI = request.getRequestURI();

        if (URI.contains("/login.jsp") || URI.contains("/loginServlet") || URI.contains("/js/") || URI.contains("/css/") || URI.contains("/fonts/") || URI.contains("/checkCodeServlet")) {
            chain.doFilter(req, resp);
        }else {
           AdminUser au = (AdminUser)request.getSession().getAttribute("admin");
           if (au != null){
               chain.doFilter(req, resp);
           }else {
               request.setAttribute("login_error","您尚未登陆，请先登陆！");
               request.getRequestDispatcher("/login.jsp").forward(request,response);
           }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
