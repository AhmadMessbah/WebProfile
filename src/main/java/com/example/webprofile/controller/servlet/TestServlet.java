package com.example.webprofile.controller.servlet;

import com.example.webprofile.model.service.Service;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/testing")
public class TestServlet extends HttpServlet {
    @Inject
//    private PersonService service;
private Service service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().setAttribute("jjj",AttachmentController.findAll().toString());
        try {
//            service.test();
//            System.out.println(service.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
