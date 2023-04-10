package controller;

import com.google.gson.Gson;
import dao.Impl.TeacherDaoImpl;
import dao.TeacherDao;
import stl.Page;
import stl.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        if (pageNo!=null){
            pageNum=Integer.parseInt(pageNo);
        }
        if (pageSizes!=null) {
            pageSize = Integer.parseInt(pageSizes);
        }

        TeacherDao teacherDao = new TeacherDaoImpl();

        int total = teacherDao.querysl();
        Page page = new Page(pageNum,pageSize,total);

        List<Teacher> teacherList = teacherDao.query(page.getStart(), pageSize);
        Gson gson = new Gson();
        String s1 = gson.toJson(page);
        String s = gson.toJson(teacherList);

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
