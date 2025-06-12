package Core;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Database database = null;
    private Connection conn = null;
    private final String URL = "jdbc:mysql://localhost:3306/sürü yönetimi";
    private final String USER = "root";
    private final String PASS = "elmaZ1024BERK";

    private Database() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        return conn;
    }

    public static Connection getDatabase() {
        try {
            if(database == null || database.getConnection().isClosed()){
                database = new Database();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return database.getConnection();
    }
    
}
