package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;  // Add this import for PrintWriter
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");
        double result = 0;

        switch (operation) {
            case "add": result = num1 + num2; break;
            case "subtract": result = num1 - num2; break;
            case "multiply": result = num1 * num2; break;
            case "divide": 
                if (num2 != 0) result = num1 / num2;
                else {
                    out.println("Error: Division by zero!");
                    return; // Exit early if division by zero
                }
                break;
            default:
                out.println("Invalid Operation!");
                return;
        }

        out.println("Result: " + result);
    }
}

