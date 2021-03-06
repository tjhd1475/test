<%@ page import="com.RtUZS.entity.question" %><%--
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
        question []q=(question[]) session.getAttribute("temp2");
    %>
    <center>
        <form action="/RankRank/question_exam_submit.jsp">
            <table border="2">
                <%
                    for(int i=0;i<5;i++){
                %>
                    <tr>
                        <td><%=i+1%></td><td><%=q[i].getTitle()%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="radio" name="Q<%=i+1%>" value="A">A.<%=q[i].getOptionA()%>
                            <input type="radio" name="Q<%=i+1%>" value="B">B.<%=q[i].getOptionB()%>
                            <input type="radio" name="Q<%=i+1%>" value="C">C.<%=q[i].getOptionC()%>
                            <input type="radio" name="Q<%=i+1%>" value="D">D.<%=q[i].getOptionD()%>
                        </td>
                    </tr>
                <%
                }
                %>
                <tr>
                    <td><input type="submit"></td><td><input type="reset"></td>
                </tr>
            </table>
        </form>
    </center>

</body>
</html>
