package pl.coderslab.testy;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recipeNumberTest")
public class RecipeNumberTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        Integer number = recipeDao.howManyRecipe(4);
        response.getWriter().println(number);

        response.getWriter().println("PLAN");
        PlanDao planDao = new PlanDao();
        Integer number1 = planDao.howManyPlans(3);
        response.getWriter().println(number1);

    }
}
