package controller;

import dto.Ceo;
import dto.Member;
import service.CeoService;
import service.MemberService;

import java.util.Scanner;

public class AccountController {
    Scanner sc = new Scanner(System.in);
    MemberService memberService = new MemberService();
    CeoService ceoService = new CeoService();
    RestaurantController restaurantController = new RestaurantController();


    public void account(){
        System.out.println("1.로그인 \t 2.회원가입");
        int input = Integer.parseInt(sc.nextLine());

        switch (input){
            case 1: //로그인
                System.out.println("1.일반 회원 \t 2.사업자");
                int userType = Integer.parseInt(sc.nextLine());
                if(userType == 1){
                    findMember();
                } else if (userType == 2) {
                    findCeo();
                } else System.out.println("다시 입력해주세요");
                break;

            case 2:
                System.out.println("1.일반 회원 \t 2.사업자");
                userType = Integer.parseInt(sc.nextLine());
                if(userType == 1){ //일반회원 가입
                    memberJoin();
                } else if (userType == 2){ //사업자 가입
                    ceoJoin();
                } else System.out.println("다시 입력해주세요");
                break;
        }




  /*      String memberId = null;
        String password = null;
        String ceoId = null;
        if(userType == 1){ //일반회원인 경우
            memberService.login(memberId, password);
        } else if (userType == 2) {
            ceoService.login(); //로그인인 경우
        } else System.out.println("다시 입력해주세요");*/
    }


    public String findMember(){
        System.out.println("회원 ID를 입력해주세요");
        String memberId= sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String password = sc.nextLine();

        //로그인 시도
        String foundMember = memberService.login(memberId, password);
        if(foundMember != null){
            System.out.println( memberId + "님, 환영합니다");
            restaurantController.memberOption(memberId);
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다");
        }
        return foundMember;
    }


    public String findCeo(){
        System.out.println("사업자 ID를 입력해주세요");
        String ceoId= sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String password = sc.nextLine();

        CeoService ceoService = new CeoService();
        //로그인 시도
        String foundCeo = ceoService.login(ceoId, password);
        if(foundCeo != null){
            System.out.println( ceoId + "님, 환영합니다" );
            restaurantController.ceoOption(ceoId);
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다");
        }
        return foundCeo;
    }


    public void memberJoin(){
         System.out.println("----일반유저 회원가입----");
         System.out.println("사용할 ID를 입력해주세요");
         String memberId = sc.nextLine();
         System.out.println("비밀번호를 입력해주세요");
         String password = sc.nextLine();
         System.out.println("이름을 입력해주세요");
         String name = sc.nextLine();
         System.out.println("전화번호를 입력해주세요");
         String tel = sc.nextLine();
         System.out.println("주소를 입력해주세요");
         String address = sc.nextLine();

         Member member = new Member(memberId, password, name, tel, address);
         memberService.join(member);
         account();
    }

    public void ceoJoin(){
        System.out.println("----사업자 회원가입----");
        System.out.println("사용할 ID를 입력해주세요");
        String ceoId = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String password = sc.nextLine();
        System.out.println("이름을 입력해주세요");
        String name = sc.nextLine();
        System.out.println("전화번호를 입력해주세요");
        String tel = sc.nextLine();
        System.out.println("주소를 입력해주세요");
        String address = sc.nextLine();
        System.out.println("사업자번호를 입력해주세요");
        String businessNum= sc.nextLine();

        Ceo ceo = new Ceo(ceoId, password, name, tel, address, businessNum);
        ceoService.join(ceo);
        account();
    }
}
