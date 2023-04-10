import Utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter("/*")
public class Filters2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转类型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Headers","*");
        resp.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");

        //获取uri
        String uri = req.getRequestURI();

        if (uri.equals("/Student2_war/Usercontroller") ){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = req.getHeader("token");
        if (token==null){
            resp.setCharacterEncoding("utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write("loginNo");
            return;
        }

        JwtUtils jwtUtils = new JwtUtils();
        boolean b = jwtUtils.getboolean(token);
        if (!b){
            resp.setCharacterEncoding("utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write("loginNo");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }


    @Override
    public void destroy() {
    }
}
