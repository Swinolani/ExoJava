package com.swino.exochien.servlet;

import com.swino.exochien.entities.Chien;
import com.swino.exochien.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ajouterChien")
public class AjouterChienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ajouterChien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String race = request.getParameter("race");
        String dateDeNaissanceStr = request.getParameter("dateDeNaissance");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDeNaissance = null;
        try {
            dateDeNaissance = dateFormat.parse(dateDeNaissanceStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Chien chien = new Chien();
        chien.setNom(nom);
        chien.setRace(race);
        chien.setDateDeNaissance(dateDeNaissance);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(chien);
        transaction.commit();
        session.close();

        response.sendRedirect(request.getContextPath() + "/chiens");
    }
}
