import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static MysqlDataSource dataSource;
    static {
        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/library_db?characterEncoding=utf8&useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("454284665");
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
