package repository;

import conn.DBConnect;
import dto.Favorite;
import dto.Member;
import dto.Restaurant;
import oracle.jdbc.proxy.annotation.Pre;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FavoriteRepository {
    DBConnect db = new DBConnect();
    Connection conn = null;


    //favorite 추가
    public void insertFavorite(int restaurantId, String memberId){
        conn = db.connect();

        //레스토랑 추가 됐는지 중복확인 쿼리문
        String sql = "select name, tel, address, intro, notice\n" +
                "from restaurant A\n" +
                "INNER JOIN favorite ON (A.id = favorite.restaurant_id)\n" +
                "WHERE favorite.member_id = ? AND favorite.restaurant_id = ?";
        try {
            PreparedStatement selectPsmt = conn.prepareStatement(sql);
            selectPsmt.setString(1, memberId);
            selectPsmt.setInt(2, restaurantId);

            ResultSet rs = selectPsmt.executeQuery();

            if(rs.next() == false) { //rs.next()결과가 없으면 추가
                sql = "INSERT INTO favorite VALUES (favorite_seq.nextval, ?, ?)";
                try {
                    //업데이트하는 갯수만큼 수가 반환된다!
                    PreparedStatement insertPsmt = conn.prepareStatement(sql);
                    insertPsmt.setString(1, memberId);
                    insertPsmt.setInt(2, restaurantId);
                    insertPsmt.executeUpdate();

                    //restaurant_id에 따른 restaurant_name이 추가되었음을 보여주기 위한 쿼리문
                    sql = "SELECT * FROM restaurant WHERE id = ? ";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.setInt(1, restaurantId);
                    ResultSet rs2 = psmt.executeQuery();
                    while (rs2.next()){
                        String name = rs2.getString("name");
                        System.out.println( name + "이 추가되었습니다");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else System.out.println("이미 추가된 음식점입니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //favorite 목록 보여주기
    public void selectFavorite(String memberId){
        conn = db.connect();
        String sql = "select name, tel, address, intro, notice\n" +
                "from restaurant A\n" +
                "INNER JOIN favorite ON (A.id = favorite.restaurant_id)\n" +
                "WHERE favorite.member_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String intro = rs.getString("intro");
                String notice = rs.getString("notice");

                System.out.println(name + "\t" +tel + "\t" + address + "\t" + intro + "\t" + notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //favorite 삭제
    public void deleteFavorite(Favorite favorite){
        conn = db.connect();
        String sql = "DELETE favorite WHERE restaurant_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, favorite.getRestaurantId());
            psmt.executeUpdate();

            System.out.println("목록에서 삭제 되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
