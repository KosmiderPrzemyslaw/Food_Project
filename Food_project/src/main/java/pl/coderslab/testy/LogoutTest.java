package pl.coderslab.testy;

import pl.coderslab.dao.RecipeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logoutTest")
public class LogoutTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();
//        Tutaj można podać id zalogowanego użytkownika
        Integer recipesNumber = recipeDao.howManyRecipe(3);
        session.setAttribute("recipesNumber", recipesNumber);

        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

    }
}
