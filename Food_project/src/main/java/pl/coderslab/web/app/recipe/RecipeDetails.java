package pl.coderslab.web.app.recipe;

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

@WebServlet("/app/recipe/details")
public class RecipeDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


       Integer id = Integer.valueOf(request.getParameter("id"));
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = recipeDao.read(id);


        session.setAttribute("recipeName", recipe.getName());
        session.setAttribute("recipeDescription", recipe.getDescription());
        session.setAttribute("recipePreparationTime", recipe.getPreparation_time());
        session.setAttribute("recipePreparation", recipe.getPreparation());
        session.setAttribute("recipeIngredients", recipe.getIngredients());

        getServletContext().getRequestDispatcher("/appRecipeDetails.jsp").forward(request, response);

    }
}
