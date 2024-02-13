package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Review {
    private int id; //PK
    private String memberId; //FK
    private int restaurantId; //FK
    private double rating; //평점
    private String reviewText; //리뷰

    public Review(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public Review(String memberId, int restaurantId, double rating, String reviewText){
        this.memberId = memberId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.reviewText = reviewText;
    }
}
