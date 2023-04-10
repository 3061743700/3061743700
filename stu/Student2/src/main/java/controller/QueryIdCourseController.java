package controller;

import com.google.gson.Gson;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.StuDao;
import stl.Course;
import stl.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QueryIdCourseController")
public class QueryIdCourseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        if (pageNo != null && pageNo != ""){
            pageNum=Integer.parseInt(pageNo);
        }
        if (pageSizes != null && pageSizes != ""){
            pageSize=Integer.parseInt(pageSizes);
        }

        CourseDao courseDao = new CourseDaoImpl();

        Course course = courseDao.queryId(cid);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("pageSize", pageSize);

        Gson gson = new Gson();

        String s = gson.toJson(course);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
