package controller;

import Utils.JdbcUtils;
import Utils.JwtUtils;
import dao.Impl.LogDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.LogDao;
import dao.StuDao;
import stl.Page;
import stl.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AddStuController")
public class AddStuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String sage = req.getParameter("sage");
        String ssex = req.getParameter("ssex");

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
        LogDao logDao = new LogDaoImpl();

        JwtUtils jwtUtils = new JwtUtils();
        String token = req.getHeader("token");
        String username = jwtUtils.getTokenUsername(token);

        Connection conn  = JdbcUtils.connection();
        try {
            strDao.add(conn,sid,sname,sage,ssex);
            logDao.log(conn,username,"insert","stu",sid);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.getClose(conn, null, null);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
