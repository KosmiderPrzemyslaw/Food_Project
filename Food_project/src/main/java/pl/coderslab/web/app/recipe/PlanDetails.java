package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/plan/details")
public class PlanDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        int id = Integer.parseInt(idParam);

        PlanDao planDao = new PlanDao();

        Plan plan = planDao.read(id);

        request.setAttribute("name", plan.getName());
        request.setAttribute("description", plan.getDescription());


        getServletContext().getRequestDispatcher("/appDetailsSchedules.jsp").forward(request, response);
    }
}
