package com.swino.exochien.servlet;

import com.swino.exochien.entities.Chien;
import com.swino.exochien.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chiens")
public class ListeChiensServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Chien> query = session.createQuery("FROM Chien", Chien.class);
        List<Chien> chiens = query.list();
        session.close();

        request.setAttribute("chiens", chiens);
        request.getRequestDispatcher("/listeChiens.jsp").forward(request, response);
    }
}
