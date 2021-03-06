package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;
import com.RtUZS.entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer,questionId;
        QuestionDao dao=new QuestionDao();
        title=req.getParameter("title");
        optionA=req.getParameter("optionA");
        optionB=req.getParameter("optionB");
        optionC=req.getParameter("optionC");
        optionD=req.getParameter("optionD");
        answer=req.getParameter("answer");
        questionId=req.getParameter("questionId");
        question q=new question(Integer.valueOf(questionId),title,optionA,optionB,optionC,optionD,answer);
        int result=dao.update(q,req);
        if(result==1){
            req.setAttribute("info","试题更新成功");
        }else {
            req.setAttribute("info","试题更新失败");
        }
        req.setAttribute("loc","/RankRank/question/find");
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
