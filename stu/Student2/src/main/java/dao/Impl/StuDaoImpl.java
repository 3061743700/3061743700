package dao.Impl;

import Utils.ThreadUtils;
import dao.StuDao;
import Utils.JdbcUtils;
import stl.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuDaoImpl implements StuDao {

    @Override
    public int querysl() {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select * from student ");
            rs = p.executeQuery();
            int i = 0;
            while(rs.next()) {
                i++;
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }
    }

    @Override
    public int querynamesl(String sid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select * from sc where sid = ?");
            p.setString(1, sid);
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
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public List<Student> query(int start,int ps) {

        List<Student> list = new ArrayList<Student>();
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;

        PreparedStatement p1=null;
        ResultSet rs1=null;

        try {
            p = conn.prepareStatement("select * from student limit ?,?");
            p.setInt(1, start);
            p.setInt(2, ps);
            rs = p.executeQuery();
            while(rs.next()) {
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String sage = rs.getString("sage");
                String ssex = rs.getString("ssex");

                p1 = conn.prepareStatement("select * from sc where sid = ?");
                p1.setInt(1, Integer.parseInt(sid));
                rs1 = p1.executeQuery();
                int sl = 0;
                int zcj = 0;
                while (rs1.next()){
                   sl++;
                    int score = rs1.getInt("score");
                    zcj += score;
                }
                Student student = new Student(sid,sname,sage,ssex,sl,zcj);
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
            JdbcUtils.getClose(conn, p1, rs1);
        }

    }

    @Override
    public List<Student> details(String sid,int start, int ps) {
        List<Student> list = new ArrayList<Student>();
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select student.*,course.cid,course.cName,course.tid,teacher.tName,sc.score " +
                    "from student \n" +
                    "LEFT JOIN sc on sc.sid=student.sid \n" +
                    "LEFT JOIN course on sc.cid=course.cid \n" +
                    "LEFT JOIN teacher on course.tid=teacher.tid  where student.sid= ? limit ?,?");
            p.setString(1,sid);
            p.setInt(2, start);
            p.setInt(3, ps);
            rs = p.executeQuery();
            int sl = 0;
            int zcj = 0;
            while(rs.next()) {
                String sname = rs.getString("sname");
                String sage = rs.getString("sage");
                String ssex = rs.getString("ssex");
                String cid = rs.getString("cid");
                String cname = rs.getString("cname");
                String tid = rs.getString("tid");
                String tname = rs.getString("tname");
                String score = rs.getString("score");
                sl++;
                zcj += Integer.parseInt(score);
                Student student = new Student(sid,sname,sage,ssex,sl,zcj,cid,cname,tid,tname,score);
                list.add(student);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public void add(Connection conn,String sid,String sname,String sage,String ssex) {

        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("insert into student(sid,sname,sage,ssex) values(?,?,?,?)");
            p.setString(1,sid);
            p.setString(2,sname);
            p.setString(3,sage);
            p.setString(4,ssex);
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
    public void del(String sid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            System.out.println(Thread.currentThread().getId());

            p = conn.prepareStatement("delete from student where sid = ?");
            p.setString(1,sid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("delete e");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }
    }

    @Override
    public Student queryId(String sid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p = null;
        ResultSet rs = null;
        Student student = new Student();
        try {
            p = conn.prepareStatement("select * from student where sid = ?");
            p.setString(1, sid);
            rs = p.executeQuery();

            while (rs.next()) {
                String sname = rs.getString("sname");
                String sage = rs.getString("sage");
                String ssex = rs.getString("ssex");

                student = new Student(sid, sname, sage, ssex);
            }

            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        } finally {
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public void update(String sid, String sname, String sage, String ssex) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("update student set sname = ?,sage = ?,ssex = ? where sid = ?");
            p.setString(1,sname);
            p.setString(2,sage);
            p.setString(3,ssex);
            p.setString(4,sid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("insertEmps error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            try {
                p.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}