package repository;

import conn.DBConnect;
import dto.Ceo;
import dto.Member;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CeoRepository {
    DBConnect db = new DBConnect();
    Connection conn = null;


    public void insert(Ceo ceo){ //사업자 회원가입
        conn = db.connect();
        String sql = "INSERT INTO ceo VALUES (?, ?, ?, ?, ?, ?, sysdate, 'N')";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, ceo.getCeoId());
            psmt.setString(2,ceo.getPassword());
            psmt.setString(3, ceo.getName());
            psmt.setString(4,ceo.getTel());
            psmt.setString(5,ceo.getAddress());
            psmt.setString(6, ceo.getBusinessNum());
            psmt.executeUpdate();

            System.out.println("사업자 회원가입이 완료 되었습니다! 로그인해주세요~ :)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disConnect();
        }
    }

    public Ceo selectCeo(String ceoId, String password){ //사업자 로그인
        conn = db.connect();
        String sql = "SELECT * FROM ceo WHERE ceo_id = ? AND password = ?";
        Ceo foundCeo = null;

        try {
            //DB에 SQL문을 실행하기 위한 객체 생성
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,ceoId);
            psmt.setString(2,password);
            ResultSet rs = psmt.executeQuery();

            if(rs.next()){
                //getString()안에 DB실제 열이름과 동일하게 넣어줘야 함
                foundCeo = new Ceo(rs.getString("ceo_id"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disConnect();
        }
        return foundCeo;
    }

    //사업자 정보 수정
    public void updateCeo(Ceo ceo){
        conn = db.connect();
        String sql = "UPDATE ceo set password =?, name =?, tel =?, address =?, business_num=? WHERE ceo_id =?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, ceo.getPassword());
            psmt.setString(2,ceo.getName());
            psmt.setString(3, ceo.getTel());
            psmt.setString(4, ceo.getAddress());
            psmt.setString(5, ceo.getBusinessNum());
            psmt.setString(6, ceo.getCeoId());

            psmt.executeUpdate();
            System.out.println("사업자 정보 수정이 완료되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
