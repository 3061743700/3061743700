package controller;

import Utils.Factory;
import Utils.JwtUtils;
import service.DelStuService;
import service.impl.DelStuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelStuController")
public class DelStuController extends HttpServlet {

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

//        StuDao strDao = new StuDaoImpl();
//        strDao.del(sid);
        System.out.println(Thread.currentThread().getId());

        JwtUtils jwtUtils = new JwtUtils();
        String token = req.getHeader("token");
        String username = jwtUtils.getTokenUsername(token);

        Object obj = Factory.factory(DelStuServiceImpl.class);
        DelStuService delStuService = (DelStuService)obj;
        delStuService.del(username,sid);

//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("utf-8");
//        PrintWriter writer = resp.getWriter();
//        writer.write("del:ok");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
