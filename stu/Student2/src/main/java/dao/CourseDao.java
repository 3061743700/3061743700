package dao;

import org.springframework.stereotype.Service;
import stl.Course;
import stl.Teacher;

import java.util.List;

public interface CourseDao {
    public List<Course> query(int start, int ps);

    int querysl();

    void add(String cid, String cname, String tid);

    void del(String cid);

    Course queryId(String cid);

    void update(String cid, String cname, String tid);
}
