package service;

import dto.Review;
import repository.ReviewRepository;

public class ReviewService {
    ReviewRepository reviewRepository = new ReviewRepository();

    public void addReview(Review review){
        reviewRepository.insertReview(review);
    }

    public void showReview(int restaurantId){
        reviewRepository.selectReview(restaurantId);
    }


}
