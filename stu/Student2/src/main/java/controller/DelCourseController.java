package controller;

import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.StuDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelCourseController")
public class DelCourseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;
        try {
            pageNum=Integer.parseInt(pageNo);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CourseDao courseDao = new CourseDaoImpl();
        courseDao.del(cid);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
