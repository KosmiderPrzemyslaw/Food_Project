package pl.coderslab.testy;

import pl.coderslab.dao.RecipePlanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/rptest")
public class Rptest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RecipePlanDao recipePlanDao = new RecipePlanDao();
//        List<String[]> test = recipePlanDao.dashboardRecipePlan(6, 14);
//        response.getWriter().println(Arrays.toString(test.get(1)));
    }
}
