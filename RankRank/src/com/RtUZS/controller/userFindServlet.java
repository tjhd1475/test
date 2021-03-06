package com.RtUZS.controller;

import com.RtUZS.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.RtUZS.entity.*;

public class userFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.【调用DAO】将查询命令推送到数据库服务器上，得到所有用户信息【list】
        UserDao dao=new UserDao();
        PrintWriter out;
        List<users> userList=dao.findAll();
        //2.【调用响应对象】将用户信息结合<table>标签命令以二进制形式写入响应体
        resp.setContentType("text/html;charset=utf-8");
        out=resp.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for(users u:userList){
            out.print("<tr>");
            out.print("<td>"+u.getUserId()+"</td>");
            out.print("<td>"+u.getUserName()+"</td>");
            out.print("<td>******</td>");
            out.print("<td>"+u.getSex()+"</td>");
            out.print("<td>"+u.getEmail()+"</td>");
            out.print("<td><a href=/RankRank/user/delete?userId="+u.getUserId()+">删除用户</a>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
