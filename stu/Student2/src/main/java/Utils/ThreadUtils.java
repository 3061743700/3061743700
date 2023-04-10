package Utils;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadUtils {
    public static ThreadLocal<Connection> map = new ThreadLocal<Connection>();

    public static void setConn(Connection conn){
        map.set(conn);
    }

    public static Connection getConn(){
        long id = Thread.currentThread().getId();
        return map.get();
    }

    public static void delConn(){
        map.remove();
    }
}
