package controller;

import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.TeacherDaoImpl;
import dao.TeacherDao;
import stl.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpTeacherController")
public class UpTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");

        String pageNums = req.getParameter("pageNum");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        try {
            pageNum=Integer.parseInt(pageNums);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TeacherDao teacherDao = new TeacherDaoImpl();


        int total = teacherDao.querysl();
        Page page = new Page(pageNum,pageSize,total);

        teacherDao.update(Integer.parseInt(tid),tname);
        req.setAttribute("page", page);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
