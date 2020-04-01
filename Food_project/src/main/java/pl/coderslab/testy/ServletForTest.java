package pl.coderslab.testy;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;


@WebServlet("/test1")
public class ServletForTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlanDao planDao = new PlanDao();
        for (int i = 0; i < planDao.findAllForUser(1).size(); i++) {
            response.getWriter().println(planDao.findAllForUser(1).get(i).getName());
        }


//        RecipeDao recipeDao = new RecipeDao();
//        Recipe recipe = new Recipe("Przepis 10", "Zupka chińska", "Opis przepisu 10", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), 25, "Opis przygotowania",1);
//        response.getWriter().println("New recipe");
//        recipeDao.create(new Recipe("Przepis Kolejny", "Sok z gumijagód", "Nazrywaj gumijagów w gumilesie", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), 55, "Wrzuć gumijagody do gumigarnka i gumigotuj przez gumikwadrans",1));
//        recipeDao.create(recipe);
//        response.getWriter().println("find all ");
//        for (int i = 0; i < recipeDao.findAll().size(); i++) {
//            response.getWriter().println(recipeDao.findAll().get(i));
//        }


//        RecipeDao recipeDao = new RecipeDao();
//        Recipe recipe = new Recipe(15,"update", "test123", "test123", 24, "prep123", 3);
//
//        PlanDao planDao = new PlanDao();
//        Plan plan = new Plan(33,"update", "descPlan123", 3);
//
//        recipeDao.update(recipe);
//        planDao.update(plan);
//

//        PlanDao planDao = new PlanDao();
//        Plan plan = new Plan("xop","Opis asdf",Timestamp.from(Instant.now()),1);
//        response.getWriter().println("New Plan");
//        planDao.create(plan);
//        response.getWriter().println("find all");
//        for (int i = 0; i < planDao.findAll().size(); i++) {
//            response.getWriter().println(planDao.findAll().get(i));
//        }

      /*  BookDao bookDao = new BookDao();
        Book book = new Book("Tytuł", "Autor", "123789456");*/

//
//        response.getWriter().println("READ  2");
//        response.getWriter().println(recipeDao.read(2));
//        response.getWriter().println("find all ");
//        for (int i = 0; i < recipeDao.findAll().size(); i++) {
//            response.getWriter().println(recipeDao.findAll().get(i));
//        }
     /*   response.getWriter().println("delete 4");
        recipeDao.delete(4);
        response.getWriter().println("find all ");
        for (int i = 0; i < recipeDao.findAll().size(); i++) {
            response.getWriter().println(recipeDao.findAll().get(i));
        }
        response.getWriter().println("update3");
        Recipe recipe1 = recipeDao.read(3);
        recipe1.setName("Buraki");
        recipe1.setDescription("Głównie buraki");
        recipeDao.update(recipe1);
        response.getWriter().println("find all ");
        for (int i = 0; i < recipeDao.findAll().size(); i++) {
            response.getWriter().println(recipeDao.findAll().get(i));
        }*/

    }
}