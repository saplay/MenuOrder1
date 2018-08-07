package com.company;

import java.util.ArrayList;

public class Menu {
    private String category, menu, price;
    private ArrayList<Menu> menusList;

    public Menu(String category, String menu, String price) {
        this.category = category;
        this.menu = menu;
        this.price = price;
    }

    public Menu() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<Menu> getMenusList() {
        return menusList;
    }

    public void setMenusList(ArrayList<Menu> menusList) {
        this.menusList = menusList;
    }

    public void printMenu() {

        int i = 0;
        System.out.println("--MENU--");
        int k = 0;
        for (; k < menusList.size(); ) {
            System.out.printf("%s%n", menusList.get(k).getCategory().toUpperCase());
            for (i = k; i < menusList.size() && menusList.get(k).getCategory().equalsIgnoreCase(menusList.get(i).getCategory()); i++) {
                System.out.printf("%-25s%10s %10sBaht%n", menusList.get(i).getMenu(), menusList.get(i).getPrice(), "");
            }

            k = i - 1;
            System.out.println("");
            k++;
        }
    }

    public  int checkMenu(String name) {
        for (int i = 0; i < menusList.size(); i++) {

            if (menusList.get(i).getMenu().equalsIgnoreCase(name))
                return i;
            else if(name.equalsIgnoreCase("x")){
                return -99;
            }
        }
        return -100;
    }
}
