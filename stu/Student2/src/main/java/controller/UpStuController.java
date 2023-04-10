package controller;

import Utils.Factory;
import Utils.JwtUtils;
import dao.Impl.StuDaoImpl;
import dao.StuDao;
import service.UpdateStuService;
import service.impl.UpdateStuServiceImpl;
import stl.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpStuController")
public class UpStuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String sage = req.getParameter("sage");
        String ssex = req.getParameter("ssex");

        String pageNums = req.getParameter("pageNum");
        String pageSizes = req.getParameter("pageSize");

        int pageNum=1,pageSize=5;

        try {
            pageNum=Integer.parseInt(pageNums);
            pageSize=Integer.parseInt(pageSizes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StuDao strDao = new StuDaoImpl();

        int total = strDao.querysl();
        Page page = new Page(pageNum,pageSize,total);

        String token = req.getHeader("token");
        JwtUtils jwtUtils = new JwtUtils();
        String username = jwtUtils.getTokenUsername(token);

        Object o = Factory.factory(UpdateStuServiceImpl.class);
        UpdateStuService updateService = (UpdateStuService)o;
        updateService.updete(username,sid,sname,sage,ssex);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
