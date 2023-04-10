package controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UpdateCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpCourseController")
public class UpCourseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        String tid = req.getParameter("tid");

        String pageNums = req.getParameter("pageNum");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;


        if (pageNums != null && pageNums != ""){
            pageNum=Integer.parseInt(pageNums);
        }
        if (pageSizes != null && pageSizes != ""){
            pageSize=Integer.parseInt(pageSizes);
        }


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object oUpdateCourseService = context.getBean("updateCourseServiceImpl");
        UpdateCourseService updateCourseService = (UpdateCourseService)oUpdateCourseService;
//        UpdateCourseService updateCourseService = new UpdateCourseServiceImpl();
        updateCourseService.updateCourse(cid,cname,tid);

//        CourseDao courseDao = new CourseDaoImpl();
//        courseDao.update(cid,cname,tid);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
