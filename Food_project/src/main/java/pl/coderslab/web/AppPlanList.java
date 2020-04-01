package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admins;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/app/plan/list")
public class AppPlanList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PlanDao planDao = new PlanDao();
        if (session.getAttribute("login")!=null) {
            int adminId = ((Admins) session.getAttribute("login")).getId();
            List list = planDao.findAllForUser(adminId);
            request.setAttribute("list", list);
        }
        request.getServletContext().getRequestDispatcher("/appPlanList.jsp").forward(request, response);
    }
}
