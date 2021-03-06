package com.RtUZS.dao;

import com.RtUZS.entity.question;
import com.RtUZS.util.jdbcutil;
import com.RtUZS.util.jdbcutiltest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private jdbcutil util =new jdbcutil();
    public int add(question q, HttpServletRequest request){
        String sql="insert into t_question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        PreparedStatement ps= util.createStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,q.getTitle());
            ps.setString(2, q.getOptionA());
            ps.setString(3, q.getOptionB());
            ps.setString(4, q.getOptionC());
            ps.setString(5, q.getOptionD());
            ps.setString(6, q.getAnswer());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    public List findAll(HttpServletRequest request){
        String sql="select * from t_question";
        PreparedStatement ps= util.createStatement(sql);
        ResultSet rs=null;
        List questionList=new ArrayList();
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                Integer questionId=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String answer=rs.getString("answer");
                question q=new question(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(q);
            }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            try {
                util.close(rs,request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }
    public int delete(Integer questionId,HttpServletRequest request){
        String sql="delete from t_question where questionId=?";
        int result=0;
        PreparedStatement ps= util.createStatement(sql,request);
        try {
            ps.setString(1,questionId.toString());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }
    public List findKeyWord(String keyword,HttpServletRequest request){
        String sql="select * from t_question where title like concat('%',?,'%') and title like concat('%',?,'%')  and title like concat('%',?,'%') ";
        PreparedStatement ps= util.createStatement(sql);
        ResultSet rs=null;
        List questionList=new ArrayList();
        String[] keywordSub = new String[3];
        int j=keyword.length()/3;
        for(int i=0;i<3;i+=1){
            keywordSub[i]=keyword.substring(i*j,(i+1)*j);
            if(j==0){
                keywordSub[i]=keyword;
            }
            try {
                ps.setString(i+1,keywordSub[i]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        try {
            rs=ps.executeQuery();
            while(rs.next()){
                Integer questionId=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String answer=rs.getString("answer");
                question q=new question(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(q);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                util.close(rs,request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }
    public question findById(String questionId,HttpServletRequest request){
        String sql="select * from t_question where questionId=?";
        ResultSet rs=null;
        question q=null;
        PreparedStatement ps= util.createStatement(sql,request);
        try {
            ps.setString(1,questionId);
            rs=ps.executeQuery();
            if(rs==null){
                return null;
            }
            while(rs.next()){
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String answer=rs.getString("answer");
                q=new question(Integer.valueOf(questionId), title, optionA, optionB, optionC, optionD, answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                util.close(rs,request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return q;
    }
    public int update(question q,HttpServletRequest request){
        String sql="update t_question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps= util.createStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,q.getTitle());
            ps.setString(2, q.getOptionA());
            ps.setString(3, q.getOptionB());
            ps.setString(4, q.getOptionC());
            ps.setString(5, q.getOptionD());
            ps.setString(6, q.getAnswer());
            ps.setString(7,q.getQuestionId().toString());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;

    }
    public int findMaxQuestionId(HttpServletRequest request){
        String sql="select * from t_question order by questionId desc limit 0,1";
        PreparedStatement ps=util.createStatement(sql,request);
        String questionId= null;
        ResultSet rs=null;
        try {
            rs=ps.executeQuery();
            if(rs==null){
                return 0;
            }
            while(rs.next())
                questionId = rs.getString("questionId");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                util.close(rs,request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int result=Integer.valueOf(questionId);
        return result;
    }
    public List findRand(HttpServletRequest request){
        String sql="select * from t_question order by rand() limit 0,5";
        PreparedStatement ps= util.createStatement(sql);
        ResultSet rs=null;
        List questionList=new ArrayList();
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                Integer questionId=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String answer=rs.getString("answer");
                question q=new question(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                util.close(rs,request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }
}
