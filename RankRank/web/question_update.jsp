<%@ page import="com.RtUZS.entity.question" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/2/28
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    question q=(question) request.getAttribute("temp1");
%>
<center>
<form action="/RankRank/question/update">
    <table border="2">
        <tr>
            <td>题目编号<input type="text" name="questionId" value="<%=q.getQuestionId()%>" readonly></td>
        </tr>
        <tr>
            <td>题目<input type="text" name="title" value="<%=q.getTitle()%>"></td>
        </tr>
        <tr>
            <td>A选项<input type="text" name="optionA" value="<%=q.getOptionA()%>"></td>
        </tr>
        <tr>
            <td>B选项<input type="text" name="optionB"value="<%=q.getOptionB()%>"></td>
        </tr>
        <tr>
            <td>C选项<input type="text" name="optionC"value="<%=q.getOptionC()%>"></td>
        </tr>
        <tr>
            <td>D选项<input type="text" name="optionD"value="<%=q.getOptionD()%>"></td>
        </tr>
        <tr>
            <td>正确答案
                <input type="radio" name="answer" value="A" <%=q.getAnswer().equals("A")?"checked":""%>>A
                <input type="radio" name="answer" value="B" <%=q.getAnswer().equals("B")?"checked":""%>>B
                <input type="radio" name="answer" value="C" <%=q.getAnswer().equals("C")?"checked":""%>>C
                <input type="radio" name="answer" value="D" <%=q.getAnswer().equals("D")?"checked":""%>>D
            </td>
        </tr>
        <tr>
            <td>题目图片 <input type="file" name="imgloc"></td>
        </tr>
        <tr>
            <td><input type="submit"value="修改试题"><input type="reset"></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
