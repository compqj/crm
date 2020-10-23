package com.bjpwoernode.crm.web.filter;


import com.bjpwoernode.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入验证是否登录的过滤器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getServletPath();
        //不应该拦截的请求
        if ("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)){
            chain.doFilter(req,resp);
        }else {//其他资源需要验证

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //登录过
            if (user != null){
                chain.doFilter(req,resp);
            }else {
                //重定向到登录页
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }

        }


    }
}
