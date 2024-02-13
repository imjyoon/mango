package service;

import dto.Menu;
import repository.MemberRepository;
import repository.MenuRepository;

public class MenuService {
    MenuRepository menuRepository = new MenuRepository();

    public void addMenu(Menu menu){
        menuRepository.insertMenu(menu);
    }
}
