package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        List questionlist=dao.findAll(req);
        req.setAttribute("findresult",questionlist);
        req.getRequestDispatcher("/questionfind.jsp").forward(req,resp);
    }
}
