<%@ page import="com.RtUZS.entity.question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/3/6
  Time: 16:53
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
    <form action="/RankRank/question_exam_submit2.jsp">
        <table border="2">
            <%
                int i=0;
                for(question q:questionList){
            %>
            <tr>
                <td><%=i+1%></td><td colspan="4"><%=q.getTitle()%></td>
            </tr>
            <tr>
                <td>选项</td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="A">A.<%=q.getOptionA()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="B">B.<%=q.getOptionB()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="C">C.<%=q.getOptionC()%>
                </td>
                <td>
                    <input type="radio" name="Q<%=i+1%>" value="D">D.<%=q.getOptionD()%>
                </td>
            </tr>
            <%
                    i++;
                }
            %>
            <tr>
                <td><input type="submit"></td><td colspan="4"><input type="reset"></td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
