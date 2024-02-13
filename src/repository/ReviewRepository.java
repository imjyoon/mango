package repository;

import conn.DBConnect;
import dto.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRepository {
    DBConnect db = new DBConnect();
    Connection conn = null;
    Review review = new Review();


    //리뷰 남기기
    public void insertReview(Review review){
        conn = db.connect();
        String sql = "INSERT INTO review VALUES (review_seq.nextval, ?, ?, ?, ?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,review.getMemberId());
            psmt.setInt(2, review.getRestaurantId());
            psmt.setDouble(3, review.getRating());
            psmt.setString(4, review.getReviewText());
            psmt.executeUpdate();

            System.out.println("리뷰가 추가되었습니다");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //리뷰 보기
    public void selectReview(int restaurantId){
        conn = db.connect();
        String sql = "SELECT restaurant.name, member_id, rating, review_text \n" +
                "FROM review r\n" +
                "LEFT JOIN restaurant ON (r.restaurant_id = restaurant.id)\n" +
                "WHERE  restaurant_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, restaurantId);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String memberId = rs.getString("member_id");
                String rating = rs.getString("rating");
                String reviewText = rs.getString("review_text");

                System.out.println(memberId +"\t"+ rating+ "\t" + reviewText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
