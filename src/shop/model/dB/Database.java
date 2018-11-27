package shop.model.dB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //b4 connection is initiated
    private static Connection connect=null;

    public static Connection getConnection(){
        String usrname="root";
        String url="Jdbc:MYSQL://localhost:3306/shop";
        String pwd="Mypass123#";
        try{
            connect=DriverManager.getConnection(url,usrname,pwd);
            if (connect!=null)
                return connect;
        } catch (SQLException e) {
            //print the content of the stack after an exception has occurred
           System.err.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
