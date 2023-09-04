package com.example.gmailclient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginControl", urlPatterns = "/login")
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        boolean status= VerifyLogin.checkLogin(user,pass);


        if(status==true){
            HttpSession session=request.getSession();
            session.setAttribute("username",user);
            out.print("Welcome    " + user);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.include(request, response);
        }
        else{
            String Error="Please check your EMail and Password";
            request.setAttribute("Error", Error);

            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.include(request, response);

        }
        out.close();

    }
}