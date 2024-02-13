package repository;

import conn.DBConnect;
import dto.Menu;
import dto.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRepository {
    DBConnect db = new DBConnect();
    Menu menu = new Menu();

    //메뉴 추가
    public void insertMenu(Menu menu){
        Connection conn = db.connect();
        Restaurant restaurant = new Restaurant();
        String sql = "INSERT INTO menu VALUES (menu_seq.nextval, ?, ?, ?, ?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, menu.getRestaurantId());
            psmt.setString(2, menu.getName());
            psmt.setInt(3, menu.getPrice());
            psmt.setString(4, menu.getIntro());
            psmt.executeUpdate();
            System.out.println(menu.getName() + "가 추가되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //메뉴 수정하기
/*    public void updateByName(){
        Connection conn = db.connect();
        String sql = "UPDATE menu set name = ?, price = ?, intro = ? where name =?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, menu.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
}
