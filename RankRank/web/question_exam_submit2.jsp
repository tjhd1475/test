<%@ page import="com.RtUZS.entity.question" %>
<%@ page import="java.util.List" %><%--
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
    List<question> questionList=(List) session.getAttribute("temp2");
%>
<center>
    <form action="/RankRank/question.html">
        <table border="2">
            <%
                int i=0;
                for(question q:questionList){
            %>
            <tr>
                <td><%=i+1%></td><td colspan="4"><%=q.getTitle()%></td><td>正/误</td>
            </tr>
            <tr>
                <td>选项</td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="A" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("A")?"checked":""%> readonly>A.<%=q.getOptionA()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="B" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("B")?"checked":""%> readonly>B.<%=q.getOptionB()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="C" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("C")?"checked":""%> readonly>C.<%=q.getOptionC()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="D" <%=(request.getParameter("Q".concat(String.valueOf(i+1)))).equals("D")?"checked":""%> readonly>D.<%=q.getOptionD()%>
                </td>
                <td><%=q.getAnswer().equals(request.getParameter("Q".concat(String.valueOf(i+1))))?"正确":"错误:正确答案是".concat(q.getAnswer())%></td>
            </tr>
            <%
                    i++;
                }
            %>
            <tr>
                <td colspan="6"><input type="submit" value="结束考试"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
