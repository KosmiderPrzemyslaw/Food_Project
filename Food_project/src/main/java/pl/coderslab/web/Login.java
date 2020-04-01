package pl.coderslab.web;

import pl.coderslab.dao.AdminsDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AdminsDao adminsDao = new AdminsDao();

        Admins admins = adminsDao.readAdminFromEmail(email);

        try {
            if (admins.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", admins);
                response.sendRedirect("/dashboard");

            } else {
                response.sendRedirect("/login");
            }
        } catch (NullPointerException e) {

            response.sendRedirect("/login");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }
}
