package dao;

import stl.Student;

import java.sql.Connection;
import java.util.List;

public interface StuDao {
    public int querysl();
    int querynamesl(String sid);
    public List<Student> query(int start, int ps);
    public List<Student> details(String sid,int start, int ps);
    void add(Connection conn, String sid, String sname, String sage, String ssex);
    void del(String sid);
    Student queryId(String sid);

    void update(String sid, String sname, String sage, String ssex);
}
