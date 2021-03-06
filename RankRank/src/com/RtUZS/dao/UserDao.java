package com.RtUZS.dao;
import com.RtUZS.util.jdbcutil;
import com.RtUZS.entity.users;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private jdbcutil util=new jdbcutil();
    public int add(users u){
        String sql="insert into users(userName,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps=util.createStatement(sql);
        int result =0;
        try {
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getSex());
            ps.setString(4, u.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //add重载
    public int add(users u, HttpServletRequest request){
        String sql="insert into users(userName,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps=util.createStatement(sql,request);
        int result =0;
        try {
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getSex());
            ps.setString(4, u.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }
    public List findAll(){
        String sql="Select * from users";
        PreparedStatement ps= util.createStatement(sql);
        ResultSet rs=null;
        List userList=new ArrayList();
        try {
            rs=ps.executeQuery();
            while(rs.next()) {
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                users u = new users(userId, userName, password, sex, email);
                userList.add(u);
            }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            try {
                util.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
    public int delete(String userId){
        String sql="delete from users where userId=?";
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    public int search(String userName,String password){
        String sql="select count(*) from users where userName=? and password=?";
        PreparedStatement ps= util.createStatement(sql);
        int result =0;
        ResultSet rs=null;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                util.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
