package controller;

import Utils.Factory;
import Utils.JwtUtils;
import service.AddCourseService;
import service.impl.AddCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCourseController")
public class AddCourseController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
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

        String token = req.getHeader("token");
        JwtUtils jwtUtils = new JwtUtils();
        String username = jwtUtils.getTokenUsername(token);

        Object o = Factory.factory(AddCourseServiceImpl.class);
        AddCourseService addCourseService = (AddCourseService) o;
        addCourseService.add(username,cid,cname,tid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
