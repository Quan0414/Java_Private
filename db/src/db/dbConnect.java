package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
    private static Connection connection;

    public static Connection getConnection() throws SQLException{
        if(connection == null){
            String url = "jdbc:mysql://localhost:3306/hit_java_private_15";
            String user = "root";
            String password  = "quan14042005";
            connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }

}
