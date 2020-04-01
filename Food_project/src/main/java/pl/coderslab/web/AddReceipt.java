package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admins;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/recipe/add")
public class AddReceipt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session = request.getSession();
            Admins admin = (Admins) session.getAttribute("login");


            String name = request.getParameter("name");
            String ingredients = request.getParameter("ingredients");
            String description = request.getParameter("description");
            int preparationTime = Integer.parseInt(request.getParameter("preparationTime"));
            String preparation = request.getParameter("preparation");


            Recipe recipe = new Recipe(name, ingredients, description, preparationTime, preparation, admin.getId());
            RecipeDao recipeDao = new RecipeDao();
            recipeDao.create(recipe);


            response.sendRedirect("/app/recipe/list");

        } catch (NumberFormatException e) {
            request.getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
    }
}
