package com.RtUZS.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money,method;
        money=req.getParameter("money");
        method=req.getParameter("method");
        Cookie card1=new Cookie("method",method);
        Cookie card2=new Cookie("money",money);
        resp.addCookie(card1);
        resp.addCookie(card2);
        req.getRequestDispatcher("/order.html").forward(req,resp);

    }
}
