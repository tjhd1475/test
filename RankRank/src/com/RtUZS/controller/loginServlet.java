package com.RtUZS.controller;

import com.RtUZS.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName,password;
        UserDao dao=new UserDao();
        int result=0;
        userName=req.getParameter("userName");
        password=req.getParameter("password");
        result=dao.search(userName,password);
        if(result==1){
            HttpSession session=req.getSession();
            resp.sendRedirect("/RankRank/index2.html");
        }else {
            resp.sendRedirect("/RankRank/login_error.html");
        }
    }
}
