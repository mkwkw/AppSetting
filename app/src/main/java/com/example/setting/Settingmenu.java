//데이터의 값을 저장하는 클래스
package com.example.setting;

public class Settingmenu {
    String menu;

    public Settingmenu(String menu){
        this.menu = menu;
    }

    public String getMenu(){
        return menu;
    }

    public void setMenu(String menu){
        this.menu = menu;
    }
}
