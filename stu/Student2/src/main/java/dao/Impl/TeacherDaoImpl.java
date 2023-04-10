package dao.Impl;

import Utils.ThreadUtils;
import dao.TeacherDao;
import Utils.JdbcUtils;
import stl.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    public List<Teacher> query(int start, int ps) {

        List<Teacher> list = new ArrayList<Teacher>();
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("select * from teacher limit ?,?");
            p.setInt(1, start);
            p.setInt(2, ps);
            rs = p.executeQuery();
            while(rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");

                Teacher teacher = new Teacher(tid,tname);
                list.add(teacher);
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
            p = conn.prepareStatement("select * from teacher");
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
    public void add(String tid, String tname) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("start transaction");
            p.executeUpdate();
            p = conn.prepareStatement("insert into journal(users,operation,dates,tables,ids) values(?,?,?,?,?) ");
            p.setString(1,"123");
            p.setString(2,"insert");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 = format.format(date);
            p.setString(3,date1);
            p.setString(4,"teacher");
            p.setString(5, String.valueOf(tid));
            int in = p.executeUpdate();
            if(in!=1) {
                throw new RuntimeException("insertJournal error");
            }

            p = conn.prepareStatement("insert into teacher(tid,tname) values(?,?)");
            p.setString(1,tid);
            p.setString(2,tname);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("insertEmps error");
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
    public void del(String tid) {
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
            p.setString(4,"teacher");
            p.setString(5, String.valueOf(tid));
            int in = p.executeUpdate();
            if(in!=1) {
                throw new RuntimeException("insertJournal error");
            }

            p = conn.prepareStatement("delete from teacher where tid = ?");
            p.setString(1,tid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("delete e");
            }

//            p = conn.prepareStatement("commit ");
//            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
        }
    }

    @Override
    public Teacher queryId(int tid) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p = null;
        ResultSet rs = null;
        Teacher teacher = new Teacher();
        try {
            p = conn.prepareStatement("select * from teacher where tid = ?");
            p.setInt(1, tid);
            rs = p.executeQuery();
            while (rs.next()) {
                String cname = rs.getString("tname");
                teacher = new Teacher(tid, cname);
            }

            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("listEmps error");
        } finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, p, rs);
        }
    }


    @Override
    public void update(int tid, String tname) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        try {
            p = conn.prepareStatement("start transaction");
            p.executeUpdate();
            p = conn.prepareStatement("insert into journal(users,operation,dates,tables,ids) values(?,?,?,?,?) ");
            p.setString(1,"123");
            p.setString(2,"update");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 = format.format(date);
            p.setString(3,date1);
            p.setString(4,"teacher");
            p.setString(5, String.valueOf(tid));
            int in = p.executeUpdate();
            if(in!=1) {
                throw new RuntimeException("insertJournal error");
            }

            p = conn.prepareStatement("update teacher set tname = ? where tid = ?");
            p.setString(1,tname);
            p.setInt(2,tid);
            int i = p.executeUpdate();
            if(i!=1) {
                throw new RuntimeException("insertEmps error");
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
}
