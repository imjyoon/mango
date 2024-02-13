package service;

import dto.Ceo;
import repository.CeoRepository;

public class CeoService {
    CeoRepository ceoRepository = new CeoRepository();
    public void join(Ceo ceo){
        ceoRepository.insert(ceo);
    }

    public String login(String ceoId, String password){
        //로그인 결과 받아오기
       return ceoRepository.selectCeo(ceoId, password).getCeoId();
    }

    public void modifyCeo(Ceo ceo){
        ceoRepository.updateCeo(ceo);
    }
}
