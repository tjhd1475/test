package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionExam2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        List questionlist=dao.findRand(req);
        HttpSession session=req.getSession();
        session.setAttribute("temp2",questionlist);
        req.getRequestDispatcher("/question_exam2.jsp").forward(req,resp);
    }
}
