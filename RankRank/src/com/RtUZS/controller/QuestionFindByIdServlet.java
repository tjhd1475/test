package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;
import com.RtUZS.entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionId=req.getParameter("questionId");
        QuestionDao dao=new QuestionDao();
        question q=dao.findById(questionId,req);
        req.setAttribute("temp1",q);
        req.getRequestDispatcher("/question_update.jsp").forward(req,resp);
    }
}
