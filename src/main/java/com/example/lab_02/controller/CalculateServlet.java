package com.example.lab_02.controller;

import com.example.lab_02.model.Calculator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    Calculator calculator = new Calculator();

    public boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");
        String cParam = request.getParameter("c");
        String dParam = request.getParameter("d");

        HttpSession session = request.getSession();
        session.setAttribute("a", aParam);
        session.setAttribute("b", bParam);
        session.setAttribute("c", cParam);
        session.setAttribute("d", dParam);

        RequestDispatcher dispatcher;
        if (isNumeric(aParam) && isNumeric(bParam) && isNumeric(cParam) && isNumeric(dParam)) {
            double a = Double.parseDouble(aParam);
            double b = Double.parseDouble(bParam);
            double c = Double.parseDouble(cParam);
            double d = Double.parseDouble(dParam);
            double result19 = calculator.calculateTask19(a, b, c, d);
            if (Double.isNaN(result19))
                dispatcher = request.getRequestDispatcher("view/nan-message.jsp");
            else {
                request.setAttribute("result19", result19);
                dispatcher = request.getRequestDispatcher("view/answer.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("view/error-message.jsp");
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
