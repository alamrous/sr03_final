package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnexionBDD { private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
private static final String USERNAME = "java";
private static final String PASSWORD = "password";
private static final String MAX_POOL = "250";

// init connection object
private Connection connection;
// init properties object
private Properties properties;

// create properties


// connect database
public Connection connect() {
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", "root");
    connectionProps.put("password", "aghiles");


        try {
			conn = DriverManager.getConnection(
			           "jdbc:mysql://localhost:3306/test",
			           connectionProps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
   // System.out.println("Connected to database");
    return conn;
}

// disconnect database
public void disconnect() {
    if (connection != null) {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}