package controller;

import com.google.gson.Gson;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import stl.Course;
import stl.Page;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CourseContrller")
public class CourseContrller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=2;
        if (pageNo != null && pageNo != ""){
            pageNum=Integer.parseInt(pageNo);
        }
        if (pageSizes != null && pageSizes != ""){
            pageSize=Integer.parseInt(pageSizes);
        }

        CourseDao courseDao = new CourseDaoImpl();

        int total = courseDao.querysl();
        Page page = new Page(pageNum,pageSize,total);

        List<Course> courseList = courseDao.query(page.getStart(), pageSize);

        Gson gson = new Gson();
        String s1 = gson.toJson(page);
        String s = gson.toJson(courseList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
//        writer.write(s1);
        writer.write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
