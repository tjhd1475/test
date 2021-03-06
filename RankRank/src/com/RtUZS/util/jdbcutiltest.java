package com.RtUZS.util;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class jdbcutiltest {
    private String url ="jdbc:mysql://localhost:3306/animerank";
    private Connection con=null;
    private PreparedStatement ps=null;
    static {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //createCon方法重载

    public Connection createCon(HttpServletRequest request) {

        ServletContext application=request.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator it= map.keySet().iterator();
        while(it.hasNext()){
            con=(Connection) it.next();
            if((boolean) map.get(con)){
                map.put(con,false);
                break;
            }
        }
        return con;
    }

    public Connection createCon(){
        try {
            con=DriverManager.getConnection(url,"root","RtUZS");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    public PreparedStatement createStatement(String sql){
        con=createCon();
        try {
            ps=con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    //重写createStatement
    public PreparedStatement createStatement(String sql,HttpServletRequest request){
        con=createCon(request);
        try {
            ps=con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public PreparedStatement createStatement(){
        con=createCon();
        try {
            ps=con.prepareStatement("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public void close(){

        try {
            if(ps!=null)
                ps.close();
            if(con!=null)
                con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //close重载
    public void close(HttpServletRequest request){

        try {
            if(ps!=null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ServletContext application =request.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        map.put(con,true);
    }
    public void close(ResultSet rs)throws Exception{
        if(rs!=null)
            rs.close();
        close();
    }

}
