package dao.Impl;

import Utils.ThreadUtils;
import dao.CourseDao;
import Utils.JdbcUtils;
import org.springframework.stereotype.Service;
import stl.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CourseDaoImpl implements CourseDao {
    public List<Course> query(int start, int ps) {

        List<Course> list = new ArrayList<Course>();
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select * from course limit ?,?");
            p.setInt(1, start);
            p.setInt(2, ps);
            rs = p.executeQuery();
            while(rs.next()) {
                String cid = rs.getString("cid");
                String cname = rs.getString("cname");
                int tid = rs.getInt("tid");

                Course course = new Course(cid,cname,tid);
                list.add(course);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
        }

    }

    @Override
    public int querysl() {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select * from course");
            rs = p.executeQuery();
            int i = 0;
            while(rs.next()) {
               i++;
            }

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public void add(String cid, String cname, String tid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("insert into course(cid,cname,tid) values(?,?,?)");
            p.setString(1,cid);
            p.setString(2,cname);
            p.setString(3,tid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("insertEmps error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }
    }

    @Override
    public void del(String cid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("start transaction");
            p.executeUpdate();
            p = conn.prepareStatement("insert into journal(users,operation,dates,tables,ids) values(?,?,?,?,?) ");
            p.setString(1,"123");
            p.setString(2,"delete");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 = format.format(date);
            p.setString(3,date1);
            p.setString(4,"course");
            p.setString(5,cid);
            int in = p.executeUpdate();
            if(in!=1) {
                throw new RuntimeException("insertJournal error");
            }

            p = conn.prepareStatement("delete from course where cid = ?");
            p.setString(1,cid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("delete e");
            }

            p = conn.prepareStatement("commit ");
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public Course queryId(String cid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p = null;
        ResultSet rs = null;
        Course course = new Course();
        try {
            p = conn.prepareStatement("select * from course where cid = ?");
            p.setString(1, cid);
            rs = p.executeQuery();
            while (rs.next()) {
                String cname = rs.getString("cname");
                int tid = rs.getInt("tid");

                course = new Course(cid, cname, tid);
            }

            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        } finally {
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public void update(String cid, String cname, String tid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        try {
            p = conn.prepareStatement("update course set cname = ?,tid = ? where cid = ?");
            p.setString(1,cname);
            p.setString(2,tid);
            p.setString(3,cid);
            int i = p.executeUpdate();
            if(i==0) {
                throw new RuntimeException("insertEmps error");
            }
//            p = conn.prepareStatement("commit ");
//            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");

        }
    }
}
