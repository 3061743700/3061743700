package service.impl;

import Utils.JdbcUtils;
import dao.Impl.LogDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.LogDao;
import dao.StuDao;
import service.UpdateStuService;

import java.sql.Connection;

public class UpdateStuServiceImpl implements UpdateStuService {
    public void updete(String username,String sid,String sname,String sage,String ssex){
        try{
            StuDao stuDao = new StuDaoImpl();
            LogDao logDao = new LogDaoImpl();

            Connection conn = JdbcUtils.connection();
            stuDao.update(sid,sname,sage,ssex);
            logDao.log(conn,username,"update","stu",sid);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
