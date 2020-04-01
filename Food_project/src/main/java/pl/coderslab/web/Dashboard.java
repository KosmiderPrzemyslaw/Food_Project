package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Admins;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RecipeDao recipeDao = new RecipeDao();
        PlanDao planDao = new PlanDao();
        RecipePlanDao recipePlanDao = new RecipePlanDao();

        HttpSession session = request.getSession();
        if (session.getAttribute("login")!=null){
            Admins admins = (Admins) session.getAttribute("login");
            Integer recipesNumber = recipeDao.howManyRecipe(admins.getId());
            Integer planNumber = planDao.howManyPlans(admins.getId());
            Plan newestPlan = planDao.findNewestForUser(admins.getId());
            List list = recipePlanDao.dashboardRecipePlan(admins.getId(),newestPlan.getId());
            session.setAttribute("planNumber", planNumber);
            session.setAttribute("recipesNumber", recipesNumber);
            session.setAttribute("adminName",admins.getFirstName());
            request.setAttribute("listRP", list);
            request.setAttribute("planName", newestPlan.getName());


            getServletContext().getRequestDispatcher("/dashboard.jsp")
                    .forward(request, response);

        } else {
            response.sendRedirect("/login");
        }

    }
}
