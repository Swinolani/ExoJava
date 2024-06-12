package com.swino.exochien.servlet;

import com.swino.exochien.entities.Chien;
import com.swino.exochien.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import org.hibernate.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailsChien")
public class DetailsChienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Chien chien = session.get(Chien.class, id);
        session.close();

        request.setAttribute("chien", chien);
        request.getRequestDispatcher("/detailsChien.jsp").forward(request, response);
    }
}
