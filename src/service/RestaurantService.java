package service;

import dto.Ceo;
import dto.Restaurant;
import repository.MenuRepository;
import repository.RestaurantRepository;

import java.util.Map;

public class RestaurantService {
    RestaurantRepository restaurantRepository = new RestaurantRepository();


    //모든 음식점 보기
    public Map<Integer, String> displayAllRestaurant(){
        Map<Integer, String> map = restaurantRepository.selectAll();
        return map;
    };


    //음식점 검색
    public void searchByName(Restaurant restaurant){ //1) 이름으로 검색
        restaurantRepository.selectByName(restaurant);
    }

    public void searchByFood(String type){ //2) 음식타입으로 검색
        restaurantRepository.selectByType(type);
    }

    public void searchByLocation(String location){ //3) 위치로 검색
        restaurantRepository.selectByLocation(location);
    }



    //음식점 추가
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.insertRestaurant(restaurant);
    }

    //메뉴추가 할 때 음식점 검색
    public void selectRestaurant(String ceoId){
        restaurantRepository.selectByCeoId(ceoId);
    }

    //음식점 삭제
    public void deleteRestaurant(int id){
        restaurantRepository.updateRestaurant(id);
    }


}