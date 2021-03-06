<%@ page import="java.util.List" %>
<%@ page import="com.RtUZS.entity.question" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/2/28
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        List<question> questionlist=(List)request.getAttribute("findresult");
    %>
</head>
<body>
    <center>
        试题查询（输入题目关键字）<form action="/RankRank/question/search"><input type="text" name="keyword"><input type="submit" value="查询"></form><br>
        <table border="2">
            <tr align="center">
                <td>问题ID</td><td>题目</td><td>选项A</td><td>选项B</td><td>选项C</td><td>选项D</td><td>正确答案</td><td colspan="2">操作</td>
            </tr>
            <%
                for(question q:questionlist){
            %>
            <tr>
                <td><%=(int)q.getQuestionId()%></td><td><%=q.getTitle()%></td><td><%=q.getOptionA()%></td><td><%=q.getOptionB()%></td><td><%=q.getOptionC()%></td><td><%=q.getOptionD()%></td><td><%=q.getAnswer()%></td>
                <td><a href="/RankRank/question/delete?questionId=<%=q.getQuestionId()%>">删除</a> </td>
                <td><a href="/RankRank/question/findById?questionId=<%=q.getQuestionId()%>">更新</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <br><a href="/RankRank/question.html">
                <button>返回上一级</button>
            </a>
    </center>
</body>
</html>
