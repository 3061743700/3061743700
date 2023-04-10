package controller;

import com.google.gson.Gson;
import dao.Impl.StuDaoImpl;
import dao.StuDao;
import stl.Page;
import stl.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/QueryIdStuController")
public class QueryIdStuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
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

       Student student = strDao.queryId(sid);
//        req.setAttribute("pageNum", pageNum);
//        req.setAttribute("pageSize", pageSize);

        Gson gson = new Gson();
        String s = gson.toJson(student);

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
