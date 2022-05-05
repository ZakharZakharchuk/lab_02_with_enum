package com.example.lab_02.controller;

import com.example.lab_02.model.Calculator;
import com.example.lab_02.model.UserNumbers;
import com.example.lab_02.model.Validator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    Calculator calculator = new Calculator();
    Validator validator = new Validator();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        for(UserNumbers un: UserNumbers.values()){
            String name= un.name();
            un.setVal(request.getParameter(name));

        }
       /* String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");
        String cParam = request.getParameter("c");
        String dParam = request.getParameter("d");*/

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(172800);
        for(UserNumbers un: UserNumbers.values()){
            session.setAttribute(un.name(), un.getVal());

        }

        List <String> userNumb = new ArrayList<>();


        for (UserNumbers un: UserNumbers.values()) {
            userNumb.add(un.getVal());

        }


        /*session.setAttribute("a", aParam);
        session.setAttribute("b", bParam);
        session.setAttribute("c", cParam);
        session.setAttribute("d", dParam);*/




        if (validator.isNumeric(userNumb)) {

            double a = Double.parseDouble(UserNumbers.a.getVal());
            double b = Double.parseDouble(UserNumbers.b.getVal());
            double c = Double.parseDouble(UserNumbers.c.getVal());
            double d = Double.parseDouble(UserNumbers.d.getVal());
            double result = calculator.calculateTask(a, b, c, d);
            if (Double.isNaN(result))
                response.sendRedirect("view/nan-message.jsp");

            else {
                request.setAttribute("result", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/answer.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("view/error-message.jsp");
        }
    }
}
