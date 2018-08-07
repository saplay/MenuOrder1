package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ยินดีต้อนรับสู่ โปรแกรมจำลองการคำนวณการสั่งเมนูรวมถึงการคำนวนราคา");
        Menu kfc = new Menu();
        kfc.setMenusList(readMenu());
        kfc.printMenu();
        chooseMenuAndCal(kfc, kfc.getMenusList());
    }

    public static ArrayList<Menu> readMenu() {
        ArrayList<Menu> menuslist = new ArrayList<Menu>();
        File f = new File("KFCMenu.txt");
        try {
            BufferedReader kfcMenu = new BufferedReader(new FileReader(f));
            String line;
            while ((line = kfcMenu.readLine()) != null) {
                String[] dataKfcMenu = line.split("[,]");
                menuslist.add(new Menu(dataKfcMenu[0], dataKfcMenu[1], dataKfcMenu[2]));
            }

            kfcMenu.close();
            return menuslist;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuslist;
    }

    public static void chooseMenuAndCal(Menu name, ArrayList<Menu> menus) {
        String chosen = "";
        int number, priceMenu, totalPrice = 0, setNumber;
        System.out.printf("เลือกเมนูโดยพิมชื่อเมนูภาษาอังกฤษ (อย่าลืมขนาดไซส์ หรือ วงเล็บด้วยค่ะ เช่น (R),(550ml))" +
                "%nส่วนต้องการกี่ชุด กรุณาใส่รายการซ้ำตามจำนวนค่ะ%nเมื่อเสร็จรายการกรุณาพิมพ์ x แล้ว enter ค่ะ  ");
        for (int i = 1; !chosen.equalsIgnoreCase("x"); i++) {
            System.out.printf("%n%d :", i);
            chosen = input.nextLine();
            number = name.checkMenu(chosen);
            if (number == -100)
                System.out.print("ไม่มีเมนูนี้ค่ะ กรุณาพิมพ์ใหม่");
            else if (number == -99) {
                System.out.printf("ยอดรวมรายการอาหาร = %d บาท", totalPrice);
                System.out.print("\nจบการทำรายการ");
            } else {
                priceMenu = Integer.parseInt(menus.get(number).getPrice());
                System.out.printf("ราคา = %d บาทต่อชุด", priceMenu);
                System.out.print("\nจำนวนที่ต้องการ(กี่ชุด): ");
                setNumber = input2.nextInt();
                totalPrice = totalPrice + (priceMenu * setNumber);

            }

        }


    }

}




