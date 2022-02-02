package ne.edu.est.gestion_location.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UniqueConnection {
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/gestion_location", "abdoulrazak", "abdoulrazak");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }


}
