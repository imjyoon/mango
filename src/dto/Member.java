package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    private String memberId;  //아이디
    private String password;  //비밀번호
    private String name;  //이름
    private String tel;  //핸드폰번호
    private String address;  //주소
    private String createDate; //가입일
    private String deleteYn; //탈퇴여부 y:탈퇴, default: n

    public Member(String memberId){
        this.memberId = memberId;
    }
    public Member(String memberId, String password){
        this.memberId = memberId;
        this.password = password;
    }

    public Member(String password, String name, String tel, String address){
        this.password=  password;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public Member(String memberId, String password, String name, String tel, String address) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }



}
