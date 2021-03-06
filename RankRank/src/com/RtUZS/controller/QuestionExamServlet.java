package com.RtUZS.controller;

import com.RtUZS.dao.QuestionDao;
import com.RtUZS.entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class QuestionExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        Random random=new Random();
        int[]randomNum=new int[5];
        question []randomQuestion=new question[5];
        for(int i=0;i<5;i++){
            randomNum[i]=random.nextInt(dao.findMaxQuestionId(req)+1);
            randomQuestion[i]=dao.findById(String.valueOf(randomNum[i]),req);
            for(int j=0;j<i;j++){
                if(randomNum[i]==randomNum[j]||randomQuestion[i]==null){
                    i--;
                    break;
                }
            }
        }
        HttpSession session=req.getSession();
        session.setAttribute("temp2",randomQuestion);
        req.getRequestDispatcher("/question_exam.jsp").forward(req,resp);
    }
}
