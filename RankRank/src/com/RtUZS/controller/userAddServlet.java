package com.RtUZS.controller;

import com.RtUZS.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.RtUZS.entity.users;

public class userAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.【调用请求对象】读取请求头中的参数信息
        String userName,password,sex,email;
        UserDao dao=new UserDao();
        users u=null;
        int result =0;
        PrintWriter out=null;
        userName=req.getParameter("userName");
        password=req.getParameter("password");
        sex=req.getParameter("sex");
        email=req.getParameter("email");
        //2.【调用userDao】将用户信息填充INSERT命令并借助JDBC规范发送至服务器
        u=new users(null,userName,password,sex,email);
        Date startDate =new Date();
        result=dao.add(u,req);
        Date endDate = new Date();
        System.out.println("注册成功，用时"+(endDate.getTime()-startDate.getTime())+"ms");
        //3.【调用响应对象】将处理结果以二进制形式写入响应体
        resp.setContentType("text/html;charset=utf-8");
        out=resp.getWriter();
        if(result==1){
            out.print("<font style='color:black;font-size:30'><a href=\"/RankRank/index2.html\">用户信息注册成功</a></font>");
        }else {
            out.print("<font style='color:red;font-size:30'><a href=\"/RankRank\">用户信息注册失败</a></font>");
        }


    }
        //Tomcat负责销毁请求对象和响应对象
        //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
        //浏览器根据响应头中的content-type指定编译器对响应体中的二进制内容编辑
        //浏览器将编辑后的结果在窗口中展示给用户【结束】
}
