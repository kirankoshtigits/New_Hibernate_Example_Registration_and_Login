package controller;

import bean.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.CommonOperations;


public class Register extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String un=request.getParameter("un");
       String pw=request.getParameter("pw");
        Users user=new Users();
        user.setUNAME(un);
        user.setUPASSWORD(pw);
        CommonOperations commonOperations=new CommonOperations();
        user=commonOperations.registerUser(user);
        if(user.isValid()){
            HttpSession session=request.getSession();
            session.setAttribute("currentsession", user);
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("failure.jsp");
           
        }
    }
}
