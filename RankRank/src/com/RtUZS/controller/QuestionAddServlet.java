package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;
import com.RtUZS.entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        QuestionDao dao=new QuestionDao();
        title=req.getParameter("title");
        optionA=req.getParameter("optionA");
        optionB=req.getParameter("optionB");
        optionC=req.getParameter("optionC");
        optionD=req.getParameter("optionD");
        answer=req.getParameter("answer");
        question q=new question(title,optionA,optionB,optionC,optionD,answer);
        int result=dao.add(q,req);
        if(result==1){
            req.setAttribute("info","试题添加成功");
        }else {
            req.setAttribute("info","试题添加失败");
        }
        req.setAttribute("loc","/RankRank/question_Add.html");
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
