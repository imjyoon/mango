package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Favorite {
    private int id; //PK
    private String memberId; //FK
    private int restaurantId; //FK



    public Favorite(String memberId){
        this.memberId = memberId;
    }

    public Favorite(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public Favorite(String memberId, int  restaurantId){
        this.memberId = memberId;
        this.restaurantId = restaurantId;
    }
}
