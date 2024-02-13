package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    Connection conn = null;
    public Connection connect(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "mongoplate";
        String password ="mongoplate";
        try {
            conn = DriverManager.getConnection(url, id, password);
            //System.out.println("DB접속 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void disConnect(){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
