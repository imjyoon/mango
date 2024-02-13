package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Ceo {
    private String ceoId; //아이디
    private String password; //비밀번호
    private String name; //이름
    private String tel; //전화번호
    private String address; //주소
    private String businessNum;  //사업자번호


    public Ceo(String ceoId, String password) {
        this.ceoId = ceoId;
        this.password = password;
    }


}
