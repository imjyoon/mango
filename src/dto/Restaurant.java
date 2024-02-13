package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Restaurant {
    private int id; // PK
    private String ceoId; // FK
    private String name; //음식점 이름
    private String tel; //음식점 전화번호
    private String location; //음식점 위치
    private String address; //음식점 주소
    private String type; //음식점 분류 (한식, 양식, 중식..)
    private String intro; //음식점 소개
    private String notice; //음식점 공지사항
    private String deleteYn; //음식점 삭제여부(default:N, 삭제:Y)


    public Restaurant(String name){
        this.name = name;
    }


    public Restaurant(int id){
        this.id = id;
    }

    public Restaurant(String ceoId, String name, String tel, String location, String address, String type, String intro, String notice){
        this.ceoId = ceoId;
        this.name = name;
        this.tel = tel;
        this.location = location;
        this.address = address;
        this.type = type;
        this.intro = intro;
        this.notice = notice;
    }
}
