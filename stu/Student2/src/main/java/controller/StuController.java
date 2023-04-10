package controller;

import com.google.gson.Gson;
import dao.Impl.StuDaoImpl;
import dao.StuDao;
import stl.Page;
import stl.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StuController")
public class StuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Boolean b = false;
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null){
//            for (Cookie cookie : cookies) {
//                if(cookie.getName().equals("login")){
//                    b = true;
//                }
//            }
//        }
//
//        if (!b){
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//            return;
//        }


        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        try {
            pageNum=Integer.parseInt(pageNo);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StuDao strDao = new StuDaoImpl();

        int total = strDao.querysl();

        Page page = new Page(pageNum,pageSize,total);
        List<Student> studentList = strDao.query(page.getStart(), pageSize);
        page.setList(studentList);

        Gson gson = new Gson();
        String s1 = gson.toJson(page);
        String s = gson.toJson(studentList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(s1);
//        writer.write(s);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
