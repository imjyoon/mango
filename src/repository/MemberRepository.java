package repository;

import conn.DBConnect;
import dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {
    DBConnect db = new DBConnect();
    Connection conn = null; //DB와 연결된 객체


    public void insert(Member member){ //일반회원 회원가입
        conn = db.connect();
            String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, sysdate, 'N')";
            try {
                PreparedStatement psmt = conn.prepareStatement(sql);
                psmt.setString(1, member.getMemberId());
                psmt.setString(2, member.getPassword());
                psmt.setString(3, member.getName());
                psmt.setString(4, member.getTel());
                psmt.setString(5, member.getAddress());
                psmt.executeUpdate();
                System.out.println("회원가입이 완료 되었습니다! 로그인해주세요~ :)");
            } catch (SQLException e) {
                System.out.println("회원가입 실패");
                e.printStackTrace();
            } finally {
                db.disConnect();
        }
    }

    //id,비밀번호로 회원 조회
    public Member selectMember(String memberId, String password){
        conn = db.connect();
        String sql = "SELECT * FROM member where member_id = ? AND password = ?";
        Member foundMember = null;

        try {
            PreparedStatement psmt = conn.prepareStatement(sql); //sql문을 실행하기 위한 객체
            psmt.setString(1, memberId);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();

            if(rs.next()){
                //getString()안에 DB실제 열이름과 동일하게 넣어줘야 함
                foundMember = new Member(rs.getString("member_id"),rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disConnect();
        }
        return foundMember;
    }

    //개인정보수정
   public void updateMember(Member member){
        conn = db.connect();
        String sql = "UPDATE member set password = ?, name = ?, tel = ?," +
                     " address = ? where member_id= ?";

       try {
           PreparedStatement psmt = conn.prepareStatement(sql);
           psmt.setString(1, member.getPassword());
           psmt.setString(2, member.getName());
           psmt.setString(3, member.getTel());
           psmt.setString(4, member.getAddress());
           psmt.setString(5, member.getMemberId());

           psmt.executeUpdate();
           System.out.println("개인 정보 수정이 완료됐습니다");

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}



