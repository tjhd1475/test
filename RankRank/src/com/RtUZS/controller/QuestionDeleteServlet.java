package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId=new Integer(req.getParameter("questionId"));
        QuestionDao dao=new QuestionDao();
        int result=dao.delete(questionId,req);
        if(result==1){
            req.setAttribute("info","试题删除成功");
        }else {
            req.setAttribute("info","试题删除失败");
        }
        req.setAttribute("loc","/RankRank/question/find");
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
