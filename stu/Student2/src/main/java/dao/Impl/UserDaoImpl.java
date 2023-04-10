package dao.Impl;

import dao.UserDao;
import Utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public int userLogin(String name, String pwd) {
        Connection conn = JdbcUtils.connection();
        PreparedStatement p=null;
        ResultSet rs=null;
        int i=0;
        try {
            p = conn.prepareStatement("select count(*) from user where user_name=? and user_password=?");
            p.setString(1, name);
            p.setString(2,pwd);
            rs = p.executeQuery();
            if(rs.next()) {
                i= rs.getInt(1);
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("login error");
        }finally {
            JdbcUtils.getClose(conn, p, rs);
        }

    }
}
