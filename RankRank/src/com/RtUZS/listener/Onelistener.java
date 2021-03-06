package com.RtUZS.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import com.RtUZS.util.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Onelistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("启动");
        jdbcutil util=new jdbcutil();
        Map map=new HashMap();
        for(int i=1;i<=20;i++){
            Connection con=util.createCon();
            System.out.println("创建通道："+i+",通道地址："+con);
            map.put(con,true);
        }
        ServletContext application =sce.getServletContext();
        application.setAttribute("key1",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application =sce.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator it=map.keySet().iterator();
        while(it.hasNext()){
            Connection con=(Connection)it.next();
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("关闭地址为："+con+"的通道");
            }

        }
        System.out.println("关闭");
    }
}
