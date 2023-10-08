package com.junxian.pwd_manage.web.servlet;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.junxian.pwd_manage.utils.RSA;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "entry", value = "/entry")
public class CheckEntryPwd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String password = request.getParameter("password");
            JSONObject jsonObject = new JSONObject();
            InputStream inputStream = CheckEntryPwd.class.getResourceAsStream("/manager.json");
            if (inputStream != null) {
                jsonObject = JSON.parseObject(inputStream, StandardCharsets.UTF_8);
            }
            String jsonPassword = jsonObject.get("password").toString();
            System.out.println("加密过的密码：" + password);
            String decrypt = RSA.decrypt(password);
            if (decrypt.isEmpty()) {
                System.out.println("null");
            } else {
                System.out.println(decrypt);
            }
            if (RSA.decrypt(password).equals(jsonPassword)) {
                session.setAttribute("managerName", "刘俊显");
                response.setHeader("content-type", "text/html;charset=utf-8");
                response.getWriter().write("登陆成功！");
            } else {
                session.setAttribute("errMessage", "密码错误");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } catch (Exception e) {
            session.setAttribute("errMessage", "发生错误！请重试");
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
