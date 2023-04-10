package service.impl;

import Utils.JdbcUtils;
import dao.Impl.LogDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.LogDao;
import dao.StuDao;
import service.DelStuService;

import java.sql.Connection;

public class DelStuServiceImpl implements DelStuService {
    public void del(String username,String sid){
        System.out.println(Thread.currentThread().getId());

        StuDao strDao = new StuDaoImpl();
        LogDao logDao = new LogDaoImpl();

        Connection conn  = JdbcUtils.connection();

        strDao.del(sid);
        logDao.log(conn,username,"delete","stu",sid);
    }
}
