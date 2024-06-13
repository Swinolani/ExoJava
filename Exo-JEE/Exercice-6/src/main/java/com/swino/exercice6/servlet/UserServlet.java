package com.swino.exercice6.servlet;

import java.io.IOException;

import com.swino.exercice6.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.swino.exercice6.classe.User;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("connexion.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("connexion".equals(action)) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = UserService.loginUser(email, password);

            if (user != null) {
                response.getWriter().println("<h3>Connexion réussie!</h3>");
            } else {
                response.getWriter().println("<h3>Échec de la connexion. Veuillez vérifier votre email et mot de passe.</h3>");
                response.getWriter().println("<a href='connexion.jsp'>Réessayer</a>");
            }
        } else if ("inscription".equals(action)) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println( "voila :"+email+' '+password);

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            UserService.registerUser(user);

            response.getWriter().println("<h3>Inscription réussie!</h3>");
        }
        request.getRequestDispatcher("yo.jsp").forward(request, response);
    }






}
