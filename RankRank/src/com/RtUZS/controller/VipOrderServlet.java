package com.RtUZS.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VipOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ka_23_money=23;
        int ka_32_money=32;
        int ka_tv_money=66;
        String method=null;
        int money,balance=0;
        Cookie cookieArray[]=null;
        Cookie newCard=null;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        String ka=req.getParameter("order");
        cookieArray= req.getCookies();
        for(Cookie card:cookieArray){
            String key=card.getName();
            String value=card.getValue();
            if("method".equals(key)){
                method=value;
            }
            else if("money".equals(key)){
                money=Integer.valueOf(value);
                balance=money;
                if("23".equals(ka)){
                    if(ka_23_money>money){
                        out.print("<font style=\"colar:red;font-size:40px\">"+method+"余额不足</font>");
                        out.print("<br><a href=\"/RankRank/order.html\">选择其他套餐</a><br><a href=\"/RankRank/vip.html\">重新充值</a><br><a href=\"/RankRank\">返回主菜单</a>");
                    }else {
                        newCard=new Cookie("money",(money-ka_23_money)+"");
                        balance=money-ka_23_money;
                    }
                }else if("32".equals(ka)){
                    if(ka_32_money>money){
                        out.print("<font style=\"colar:red;font-size:40px\">"+method+"余额不足</font>");
                        out.print("<br><a href=\"/RankRank/order.html\">选择其他套餐</a><br><a href=\"/RankRank/vip.html\">重新充值</a><br><a href=\"/RankRank\">返回主菜单</a>");
                    }else {
                        newCard=new Cookie("money",(money-ka_32_money)+"");
                        balance=money-ka_32_money;
                    }
                }
                else if("tv".equals(ka)){
                    if(ka_tv_money>money){
                        out.print("<font style=\"colar:red;font-size:40px\">"+method+"余额不足</font>");
                        out.print("<br><a href=\"/RankRank/order.html\">选择其他套餐</a><br><a href=\"/RankRank/vip.html\">重新充值</a><br><a href=\"/RankRank\">返回主菜单</a>");
                    }else {
                        newCard=new Cookie("money",(money-ka_tv_money)+"");
                        balance=money-ka_tv_money;
                    }
                }
            }
        }
        resp.addCookie(newCard);
        out.print("余额:"+balance);
    }
}
