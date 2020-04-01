package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/recipe/plan/add")
public class AppScheduleMealRecipe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        RecipeDao recipeDao = new RecipeDao();
        DayNameDao dayNameDao = new DayNameDao();
        PlanDao planDao = new PlanDao();
        RecipePlanDao recipePlanDao = new RecipePlanDao();


        String planName = request.getParameter("plan");
        String recipeName = request.getParameter("recipe");
        String day = request.getParameter("day");
        String mealName = request.getParameter("mealName");
        int displayOrder = Integer.parseInt(request.getParameter("mealNumber"));

        int planId = 0;
        int recipId = 0;
        int dayId = 0;


        List<Plan> planList = planDao.findAll();
        for (Plan plan : planList
        ) {
            if (plan.getName().equals(planName)) {
                planId = plan.getId();
            }
        }

        List<Recipe> recipeList = recipeDao.findAll();
        for (Recipe recip : recipeList
        ) {
            if (recip.getName().equals(recipeName)) {
                recipId = recip.getId();
            }
        }

        List<DayName> dayNameList = dayNameDao.findAll();
        for (DayName dayName1 : dayNameList
        ) {
            if (dayName1.getName().equals(day)) {

                dayId = dayName1.getId();
            }
        }

        RecipePlan recipePlan = new RecipePlan(recipId, dayId, planId, displayOrder, mealName);
        recipePlanDao.create(recipePlan);

        doGet(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        PlanDao planDao = new PlanDao();
        RecipeDao recipeDao = new RecipeDao();
        DayNameDao dayNameDao = new DayNameDao();

        if (session.getAttribute("login") != null) {
            int adminId = ((Admins) session.getAttribute("login")).getId();
            List planList = planDao.findAllForUser(adminId);
            request.setAttribute("planList", planList);

            List recipeList = recipeDao.findAllForUser(adminId);
            request.setAttribute("recipeList", recipeList);

            List dayList = dayNameDao.findAll();
            request.setAttribute("dayList", dayList);

            request.getServletContext().getRequestDispatcher("/addScheduleMealRecipe.jsp").forward(request, response);


        }
    }
}