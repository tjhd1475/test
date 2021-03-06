<%@ page import="com.RtUZS.entity.question" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/3/6
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    question[]q=(question[]) session.getAttribute("temp2");
%>
<center>
<form action="/RankRank/question.html">
    <table border="2">
        <%
            for(int i=0;i<5;i++){
        %>
        <tr>
            <td><%=i+1%></td><td><%=q[i].getTitle()%></td><td>正/误</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="radio" name="Q<%=i+1%>" value="A" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("A")?"checked":""%> readonly>A.<%=q[i].getOptionA()%>
                <input type="radio" name="Q<%=i+1%>" value="B" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("B")?"checked":""%> readonly>B.<%=q[i].getOptionB()%>
                <input type="radio" name="Q<%=i+1%>" value="C" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("C")?"checked":""%> readonly>C.<%=q[i].getOptionC()%>
                <input type="radio" name="Q<%=i+1%>" value="D" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("D")?"checked":""%> readonly>D.<%=q[i].getOptionD()%>
            </td>
            <td><%=q[i].getAnswer().equals(request.getParameter("Q".concat(String.valueOf(i+1))))?"正确":"错误:正确答案是".concat(q[i].getAnswer())%></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td><input type="submit" value="结束考试"></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
