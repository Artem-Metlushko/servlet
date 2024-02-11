package com.example.message;

import com.example.message.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String queryParam = request.getParameter("message");
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = new Message(queryParam);
        response.setContentType("application/json");
        objectMapper.writeValue(response.getWriter(), message);

    }
}
