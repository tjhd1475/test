package com.RtUZS.controller;

import com.RtUZS.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class userDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId;
        UserDao dao=new UserDao();
        int result=0;
        PrintWriter out=null;
        userId=req.getParameter("userId");
        result=dao.delete(userId);
        resp.setContentType("text/html;charset=utf-8");
        out= resp.getWriter();
        if(result==1){
            out.print("<font style='color:black;font-size:30'><a href=\"/RankRank/user/find\">用户信息删除成功</a></font>");
        }else {
            out.print("<font style='color:red;font-size:30'><a href=\"/RankRank/user/find\">用户信息删除失败</a></font>");
        }
    }
}
