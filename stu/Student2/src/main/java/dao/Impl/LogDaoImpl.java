package dao.Impl;

import Utils.JdbcUtils;
import dao.CourseDao;
import dao.LogDao;
import stl.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogDaoImpl implements LogDao {
   public void log(Connection conn,String name,String cz,String table,String ids){
       conn = JdbcUtils.connection();
       PreparedStatement p=null;
       ResultSet rs=null;
       try {
           p = conn.prepareStatement("insert into journal(users,operation,dates,tables,ids) values(?,?,?,?,?) ");
           p.setString(1,name);
           p.setString(2,cz);
           Date date = new Date();
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String date1 = format.format(date);
           p.setString(3,date1);
           p.setString(4,table);
           p.setString(5,ids);
           int in = p.executeUpdate();
           if(in!=1) {
               throw new RuntimeException("insertJournal error");
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
}
