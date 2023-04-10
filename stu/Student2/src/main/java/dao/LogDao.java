package dao;

import stl.Course;

import java.sql.Connection;
import java.util.List;

public interface LogDao {
    void log(Connection conn,String name, String cz, String table, String cid);
}
