package controller;

import dto.*;
import service.*;

import java.util.Map;
import java.util.Scanner;

public class RestaurantController {
    Scanner sc = new Scanner(System.in);
    RestaurantService restaurantService = new RestaurantService();
    MenuService menuService = new MenuService();
    MemberService memberService = new MemberService();
    CeoService ceoService = new CeoService();
    FavoriteService favoriteService = new FavoriteService();



    public void memberOption(String memberId){
        System.out.println("1. 음식점 \t 2.favorite\t 3.리뷰 \t 4.개인정보수정\t 5.뒤로가기");
        int option = Integer.parseInt(sc.nextLine());

        switch (option){
            case 1:
                System.out.println("1.모든 음식점 보기\t 2.음식점 검색");
                int input = Integer.parseInt(sc.nextLine());
                if(input == 1){ // 모든 음식점보기
                    restaurantService.displayAllRestaurant();
                    break;
                }else if(input == 2){ // 음식점 검색
                    Restaurant restaurant = null;
                    System.out.println("어떤 번호로 검색할지 선택하세요");
                    System.out.println("1.음식점 이름으로 검색\t 2.음식 종류로 검색\t 3.위치로 검색");
                     input = Integer.parseInt(sc.nextLine());
                    if(input == 1){
                        System.out.println("검색할 음식점 이름을 입력해주세요");
                        String name = sc.nextLine();
                        restaurant = new Restaurant(name);
                        restaurantService.searchByName(restaurant);
                    } else if (input == 2) {
                        System.out.println("음식 종류를 입력해주세요");
                        String type = sc.nextLine();
                        restaurantService.searchByFood(type);
                    } else if (input == 3) {
                        System.out.println("검색하고 싶은 위치를 입력해주세요");
                        String location = sc.nextLine();
                        restaurantService.searchByLocation(location);
                    }else System.out.println("번호를 다시 입력해주세요");
                    break;
                }
            case 2:
                System.out.println("옵션을 선택 해주세요");
                System.out.println("1.favorite 목록 \t 2.favorite 추가\t 3.favorite 삭제");
                input = Integer.parseInt(sc.nextLine());
                if(input == 1){
                    favoriteService.showFavorite(memberId);
                    break;
                } else if (input == 2) {
                    Member member = new Member(memberId);
                    Map<Integer, String> map = restaurantService.displayAllRestaurant();
                    System.out.println("favorite에 추가 하고 싶은 음식점 번호를 입력하세요");
                    int restaurantId  = Integer.parseInt(sc.nextLine());
                    favoriteService.addFavorite(restaurantId, memberId);
                    break;
                } else if (input == 3) {
                    favoriteService.showFavorite(memberId);
                    System.out.println("삭제하고 싶은 음식점 번호를 입력하세요");
                    int restaurantId  = Integer.parseInt(sc.nextLine());
                    Favorite favorite = new Favorite(restaurantId);
                    favoriteService.removeFavorite(favorite);
                    break;
                }

            case 3:
                ReviewService reviewService= new ReviewService();
                System.out.println("1.리뷰 작성\t 2.리뷰 보기");
                input = Integer.parseInt(sc.nextLine());
                if(input == 1){
                    restaurantService.displayAllRestaurant();
                    System.out.println("리뷰를 남기고 싶은 음식점 번호를 입력해주세요");
                    int restaurantId = sc.nextInt();
                    System.out.println("평점을 입력해주세요");
                    double rating = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("리뷰를 남겨주세요");
                    String reviewText = sc.nextLine();
                    Review review = new Review(memberId, restaurantId, rating, reviewText);
                    reviewService.addReview(review);
                    break;
                } else if (input == 2) {
                    restaurantService.displayAllRestaurant();
                    System.out.println("음식점 번호를 입력해주세요");
                    int restaurantId = sc.nextInt();
                    sc.nextLine();
                    reviewService.showReview(restaurantId);
                    break;
                }
            case 4:
                Member member = null;
                System.out.println("변경할 비밀번호를 입력해주세요");
                String password= sc.nextLine();
                System.out.println("변경할 이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.println("변경할 전화번호를 입력해주세요");
                String tel = sc.nextLine();
                System.out.println("변경할 주소를 입력해주세요");
                String address = sc.nextLine();

                member = new Member(memberId, password, name, tel, address);
                memberService.modifyMember(member);
            case 5:
                AccountController accountController = new AccountController();
                accountController.account();
        }
    }

    public void ceoOption(String ceoId){
        Restaurant restaurant = null;

        System.out.println("1.음식점 \t 2.메뉴 추가 \t 3.개인정보수정\t 4.뒤로가기");
        int option = Integer.parseInt(sc.nextLine());

        switch (option){
            case 1:
                System.out.println("1.음식점 등록\t 2.등록한 음식점 확인\t 3.음식점 철회");
                int input = Integer.parseInt(sc.nextLine());
                if(input == 1){
                    System.out.println("음식점 이름을 입력해주세요");
                    String name = sc.nextLine();
                    System.out.println("음식점 전화번호를 입력해주세요");
                    String tel = sc.nextLine();
                    System.out.println("음식점 위치를 입력해주세요");
                    String location = sc.nextLine();
                    System.out.println("음식점 주소를 입력해주세요");
                    String address = sc.nextLine();
                    System.out.println("음식점 타입을 입력해주세요");
                    String type = sc.nextLine();
                    System.out.println("음식점을 소개와 정보를 입력해주세요");
                    String intro = sc.nextLine();
                    System.out.println("공지사항을 입력해주세요");
                    String notice = sc.nextLine();

                    restaurant = new Restaurant(ceoId, name, tel, location, address, type, intro, notice);
                    restaurantService.addRestaurant(restaurant);
                    break;
                } else if (input == 2) {
                    restaurantService.selectRestaurant(ceoId);
                    break;
                } else if (input ==3) {
                    restaurantService.selectRestaurant(ceoId);
                    System.out.println("삭제하고 싶은 음식점 번호를 입력하세요");
                    int id = sc.nextInt();
                    sc.nextLine();
                    restaurantService.deleteRestaurant(id);
                    break;
                } else System.out.println("번호를 다시 입력해주세요");

            case 2:
                restaurantService.selectRestaurant(ceoId);
                System.out.println("메뉴를 등록할 음식점 번호를 입력하세요");
                int restaurantId = sc.nextInt();
                sc.nextLine();
                System.out.println("등록할 메뉴 이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.println("가격을 입력해주세요");
                int price = sc.nextInt();
                sc.nextLine();
                System.out.println("음식에 대한 설명을 입력해주세요");
                String intro = sc.nextLine();

                Menu menu = new Menu(restaurantId, name, price, intro);
                menuService.addMenu(menu);
                break;

            case 3:
                Ceo ceo = null;
                System.out.println("변경하고 싶은 비밀번호를 입력하세요");
                String password = sc.nextLine();
                System.out.println("변경하고 이름으로 입력하세요");
                name = sc.nextLine();
                System.out.println("변경하고 싶은 번호로 입력하세요");
                String tel = sc.nextLine();
                System.out.println("변경하고 싶은 주소로 입력하세요");
                String address = sc.nextLine();
                System.out.println("변경하고 싶은 사업자번호를 입력하세요");
                String businessNum = sc.nextLine();
                ceo = new Ceo(ceoId, password, name, tel, address, businessNum);
                ceoService.modifyCeo(ceo);

            case 4:
                AccountController accountController = new AccountController();
                accountController.account();

        }
    }
}
