package service.impl;

import Utils.JdbcUtils;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.LogDaoImpl;
import dao.LogDao;
import service.AddCourseService;

import java.sql.Connection;

public class AddCourseServiceImpl implements AddCourseService {
    @Override
    public void add(String username,String cid,String cname,String tid) {
        CourseDao courseDao = new CourseDaoImpl();
        LogDao logDao = new LogDaoImpl();

        Connection conn = JdbcUtils.connection();

        courseDao.add(cid,cname,tid);
        logDao.log(conn,username,"insert","course",cid);
    }

    public void a(){
        System.out.println("test");
    }
}
