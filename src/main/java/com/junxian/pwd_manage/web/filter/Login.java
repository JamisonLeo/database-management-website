package com.junxian.pwd_manage.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "login", urlPatterns = "/*")
public class Login implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        request1.setCharacterEncoding("UTF-8");
        String requestURI = request1.getRequestURI();
        HttpSession session = request1.getSession();
        if (requestURI.contains("index.jsp") || requestURI.contains("/css/")
                || requestURI.contains("/js/") || requestURI.contains("/lib/")
                || requestURI.contains("/font/") || requestURI.contains("entry.jpg")
                || requestURI.contains("entry") || requestURI.equals(request1.getContextPath() + "/")
                || requestURI.contains("favicon.ico")) {
            chain.doFilter(request1, response1);
        } else {
            if (session.getAttribute("managerName") != null) {
                chain.doFilter(request1, response1);
            } else {
                session.setAttribute("errMessage", "尚未登录，请先登录！");
                response1.sendRedirect(request1.getContextPath() + "/index.jsp");
            }
        }
    }
}
