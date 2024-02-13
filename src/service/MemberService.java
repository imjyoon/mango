package service;

import dto.Member;
import repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    RestaurantService restaurantService = new RestaurantService();
    public void join(Member member){
        memberRepository.insert(member);
    }

    public String login(String memberId, String password){
        //로그인 결과 받아오기
        return memberRepository.selectMember(memberId, password).getMemberId();
    }

    //개인정보수정
    public void modifyMember(Member member){
        memberRepository.updateMember(member);
    }
}
