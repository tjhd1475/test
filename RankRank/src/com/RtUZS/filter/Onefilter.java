package com.RtUZS.filter;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Onefilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String sex=servletRequest.getParameter("sex");
        if(sex.equals("男")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out=servletResponse.getWriter();
            out.print("<center><font style='color:red;font-size:40px'><a href=\"/RankRank\">女生勿进</a></font></center>");
        }
    }
}
