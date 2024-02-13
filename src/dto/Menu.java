package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Menu {
    private int id; //PK
    private int restaurantId; //FK
    private String name; //음식 이름
    private int price; //가격
    private String intro; //음식 소개

    private Menu(int restaurantId, String name){
        this.restaurantId = restaurantId;
        this.name = name;
    }

    public Menu (int restaurantId, String name, int price, String intro){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.intro = intro;
    }


}
