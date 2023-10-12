package com.example.webprofile.controller.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@ServletSecurity(value = @HttpConstraint(
        rolesAllowed = {"admin"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(
                        value = "GET",
                        rolesAllowed = {"admin"}
                )
        }
)
@WebServlet(name = "personServlet", value = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Person Get");
        resp.getWriter().println("<H1>Person Servlet</H1>");

    }
}