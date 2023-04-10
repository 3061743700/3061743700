package controller;

import Utils.JwtUtils;
import dao.Impl.UserDaoImpl;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Usercontroller")
public class Usercontroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        UserDao dao = new UserDaoImpl();
        JwtUtils jwtUtils = new JwtUtils();

        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();

        int i = dao.userLogin(name, pwd);
        if(i==1) {
            String token = jwtUtils.getToken(name);
            writer.write(token);
        }else {
            writer.write("loginNo");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
