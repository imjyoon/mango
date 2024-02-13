package service;

import dto.Favorite;
import dto.Member;
import dto.Restaurant;
import repository.FavoriteRepository;
import repository.RestaurantRepository;

public class FavoriteService {
    FavoriteRepository favoriteRepository = new FavoriteRepository();

    //favorite 추가
    public void addFavorite(int restaurantId, String memberId){
        favoriteRepository.insertFavorite(restaurantId, memberId);
    }

    //favorite 목록
    public void showFavorite(String memberId){
        favoriteRepository.selectFavorite(memberId);
    }

    //favorite 삭제
    public void removeFavorite(Favorite favorite){
        favoriteRepository.deleteFavorite(favorite);
    }
}
