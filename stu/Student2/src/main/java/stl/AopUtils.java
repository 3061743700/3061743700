package stl;

import Utils.JdbcUtils;
import Utils.ThreadUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Aspect
@Service
public class AopUtils {

    @Pointcut("execution (* service.*.*(..))")
    public void pointcut(){}



    @AfterReturning("pointcut()")
    public void afterReturning(){
        Connection conn = JdbcUtils.connection();
        try {
            conn.commit();
            conn.close();
            ThreadUtils.delConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(Exception e){
        Connection conn = JdbcUtils.connection();
        try {
            conn.rollback();
            conn.commit();
            ThreadUtils.delConn();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



//
//    @Around("pointcut()")
//    public void around(ProceedingJoinPoint pjp){
//        Connection conn = null;
//        try {
//            Object[] args = pjp.getArgs();
//
//            conn = JdbcUtils.connection();
//
//            Object proceed = pjp.proceed(args);
//
//            conn.commit();
//        } catch (Throwable e) {
//            try {
//                conn.commit();
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//            throw new RuntimeException(e);
//        }finally {
//            ThreadUtils.delConn();
//            JdbcUtils.getClose(conn,null,null);
//        }
//    }
}
