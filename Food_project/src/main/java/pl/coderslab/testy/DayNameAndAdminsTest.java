//package pl.coderslab.testy;
//
//import pl.coderslab.dao.AdminsDao;
//import pl.coderslab.dao.DayNameDao;
//import pl.coderslab.model.Admins;
//import pl.coderslab.model.DayName;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/testAdmin")
//public class DayNameAndAdminsTest extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        DayNameDao dayNameDao = new DayNameDao();
//        DayName dayName = new DayName("swieta", 9);
//        response.getWriter().println("create name: swieta, displayOrder: 9");
//        dayNameDao.create(dayName);
//        response.getWriter().println("READ  7");
//        response.getWriter().println(dayNameDao.read(7));
//        response.getWriter().println("find all ");
//        for (int i = 0; i < dayNameDao.findAll().size(); i++) {
//            response.getWriter().println(dayNameDao.findAll().get(i));
//
//            response.getWriter().println("delete 15");
//            dayNameDao.delete(15);
//            response.getWriter().println("find all ");
//            for (int i = 0; i < dayNameDao.findAll().size(); i++) {
//                response.getWriter().println(dayNameDao.findAll().get(i));
//
//                response.getWriter().println("update7");
//                DayName dayName1 = dayNameDao.read(7);
//                dayName1.setName("odpoczynek");
//                dayNameDao.update(dayName1);
//                response.getWriter().println("find all ");
//                for (int i = 0; i < dayNameDao.findAll().size(); i++) {
//                    response.getWriter().println(dayNameDao.findAll().get(i));
//                }
//
//                AdminsDao adminsDao = new AdminsDao();
//                Admins admins = new Admins("Jan", "kowalski", "j.k@gmail.com", "aLaMAkota", 1, 1);
//
//                response.getWriter().println("create x2 Jan Kowalski ");
//                adminsDao.create(admins);
//                adminsDao.create(admins);
//
//                response.getWriter().println("READ  2");
//                response.getWriter().println(adminsDao.read(2));
//
//                response.getWriter().println("find all ");
//                for (int i = 0; i < adminsDao.findAll().size(); i++) {
//                    response.getWriter().println(adminsDao.findAll().get(i));
//                }
//
//                response.getWriter().println("delete 2");
//                adminsDao.delete(2);
//
//                response.getWriter().println("find all ");
//                for (int i = 0; i < adminsDao.findAll().size(); i++) {
//                    response.getWriter().println(adminsDao.findAll().get(i));
//                }
//
//
//                response.getWriter().println("update3");
//                Admins admins1 = adminsDao.read(3);
//                admins1.setFirstName("tomek");
//                admins1.setLastName("nowakowksi");
//                adminsDao.update(admins1);
//
//
//                response.getWriter().println("find all ");
//                for (int i = 0; i < adminsDao.findAll().size(); i++) {
//                    response.getWriter().println(adminsDao.findAll().get(i));
//                }
//
//            }
//        }
//    }
//}
