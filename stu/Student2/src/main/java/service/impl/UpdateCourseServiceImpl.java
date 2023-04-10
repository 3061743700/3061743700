package service.impl;

import Utils.JdbcUtils;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;
import dao.Impl.LogDaoImpl;
import dao.Impl.StuDaoImpl;
import dao.LogDao;
import dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.UpdateCourseService;

@Service
public class UpdateCourseServiceImpl implements UpdateCourseService {

//    @Autowired
//    CourseDao courseDao;
//
//    @Autowired
//    LogDao logDao;



    @Override
    public void updateCourse(String cid, String cname, String tid) {
        try{
            CourseDao courseDao = new CourseDaoImpl();
            LogDao logDao = new LogDaoImpl();

            courseDao.update(cid,cname,tid);
//            logDao.log(JdbcUtils.connection(),cname,"update","course", cid);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void a(){
        System.out.println("Aaa");
    }
}
