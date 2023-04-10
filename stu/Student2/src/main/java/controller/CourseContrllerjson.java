package controller;

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
import java.util.List;

@WebServlet("/CourseContrllerjson")
public class CourseContrllerjson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=2;

        try {
            pageNum=Integer.parseInt(pageNo);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CourseDao courseDao = new CourseDaoImpl();

        int total = courseDao.querysl();
        Page page = new Page(pageNum,pageSize,total);

        List<Course> courseList = courseDao.query(page.getStart(), pageSize);
        req.setAttribute("page", page);
        req.setAttribute("courseList", courseList);
        req.getRequestDispatcher("/course.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
