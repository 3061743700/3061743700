package Utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class Handler implements InvocationHandler {
    Object obj;

    public Handler(Object obj) {
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强");
        Connection conn  = JdbcUtils.connection();
        Object rs;
        try {
            rs = method.invoke(obj,args);
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ThreadUtils.delConn();
            JdbcUtils.getClose(conn, null, null);
        }
        return rs;
    }


}
