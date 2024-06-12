package com.swino.exercice4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final List<Chat> chats = new ArrayList<>();

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("chats", chats);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String race = request.getParameter("race");
        String repasFavoris = request.getParameter("repasFavoris");
        LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));
        Chat chat = new Chat(nom, race, repasFavoris, dateNaissance);
        chats.add(chat);
        response.sendRedirect("ChatServlet");
    }
}
