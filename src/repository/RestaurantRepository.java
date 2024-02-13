package repository;

import conn.DBConnect;
import dto.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RestaurantRepository {
    DBConnect db = new DBConnect();
    Connection conn = null;
    Restaurant restaurant = new Restaurant();

    //음식점 추가
    public void insertRestaurant(Restaurant restaurant){
        conn = db.connect();
        String sql = "INSERT INTO restaurant VALUES (restaurant_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 'n')";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, restaurant.getCeoId());
            psmt.setString(2, restaurant.getName());
            psmt.setString(3, restaurant.getTel());
            psmt.setString(4, restaurant.getLocation());
            psmt.setString(5, restaurant.getAddress());
            psmt.setString(6, restaurant.getType());
            psmt.setString(7, restaurant.getIntro());
            psmt.setString(8, restaurant.getNotice());

            psmt.executeUpdate();
            System.out.println( restaurant.getName() + "추가 완료됐습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disConnect();
        }
    }

    //모든 음식점 보기
    public Map<Integer, String> selectAll(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        conn = db.connect();

        String sql = "SELECT * FROM restaurant where delete_yn = 'N'";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String ceoId = rs.getString("ceo_id");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String location = rs.getString("location");
                String address = rs.getString("address");
                String type = rs.getString("type");
                String intro = rs.getString("intro");

                map.put(id, name);
                System.out.println(id+ "\t" +name +"\t" + tel +"\t" + location +"\t"+ address+ "\t" + type + "\t"+ intro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    //사업자가 등록한 음식점만 보기
    public void selectByCeoId(String ceoId){
        Connection conn = db.connect();
        String sql = "SELECT * FROM restaurant WHERE ceo_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            //ceoId 매개변수에 대한 값을 설정
            psmt.setString(1, ceoId);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()){
                String restaurantId = rs.getString("id");
                String name = rs.getString("name");
                System.out.println(restaurantId + "\t" + name );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //음식점 이름으로 검색
    public void selectByName(Restaurant restaurant){
        conn = db.connect();
        String sql = "SELECT * FROM restaurant WHERE name = ?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, restaurant.getName());
            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
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

    //음식 타입으로 검색
    public void selectByType(String type){
        conn = db.connect();
        String sql = "SELECT * FROM restaurant WHERE type = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, type);
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

    //위치로 검색
    public void selectByLocation(String location){
        conn = db.connect();
        String sql = "SELECT * FROM restaurant WHERE location = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, location);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String type = rs.getString("type");
                String intro = rs.getString("intro");
                String notice = rs.getString("notice");

                System.out.println(name + "\t" +tel + "\t" + address + "\t" + intro + "\t" + notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //음식점삭제
    public void updateRestaurant(int id){
        conn = db.connect();
        String sql = "UPDATE restaurant SET delete_yn = 'Y' WHERE id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
            System.out.println("음식점이 삭제되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
