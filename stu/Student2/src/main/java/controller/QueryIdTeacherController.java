package controller;

import com.google.gson.Gson;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.TeacherDaoImpl;
import dao.TeacherDao;
import stl.Course;
import stl.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QueryIdTeacherController")
public class QueryIdTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        try {
            pageNum=Integer.parseInt(pageNo);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TeacherDao teacherDao = new TeacherDaoImpl();

        Teacher teacher = teacherDao.queryId(Integer.parseInt(tid));
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("pageSize", pageSize);

        Gson gson = new Gson();
        String s = gson.toJson(teacher);


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
