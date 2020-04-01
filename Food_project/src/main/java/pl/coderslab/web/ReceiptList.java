package pl.coderslab.web;

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
import java.util.List;

@WebServlet("/app/recipe/list")
public class ReceiptList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();

        if (session.getAttribute("login")!=null) {
            int adminId = ((Admins) session.getAttribute("login")).getId();
            List list = recipeDao.findAllForUser(adminId);
            request.setAttribute("list", list);
        }
        request.getServletContext().getRequestDispatcher("/receiptList.jsp").forward(request, response);
    }

}
