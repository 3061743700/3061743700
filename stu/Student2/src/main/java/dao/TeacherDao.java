package dao;

import stl.Student;
import stl.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> query(int start, int ps);

    int querysl();

    void add(String tid, String tname);

    void del(String tid);

    Teacher queryId(int tid);

    void update(int tid, String tname);
}
