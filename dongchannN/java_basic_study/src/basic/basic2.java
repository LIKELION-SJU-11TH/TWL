package basic;

import java.util.Scanner;

public class basic2 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        int m50000 = money / 50000;
        money -= 50000 * m50000;

        int m10000 = money / 10000;
        money -= 10000 * m10000;

        int m1000 = money / 1000;
        money -= 1000 * m1000;

        int m100 = money / 100;
        money -= 100 * m100;

        int m50 = money / 50;
        money -= 50 * m50;

        int m10 = money / 10;
        int m1 = money % 10;

        System.out.println("오만원권 "+ m50000 + "매");
        System.out.println("만원권 "+m10000 + "매");
        System.out.println("천원권 " + m1000 + "매");
        System.out.println("백원 "+m100+ "개");
        System.out.println("오십원 " + m50 + "개");
        System.out.println("십원 "+ m10 + "개");
        System.out.println("일원 " + m1 + "개");


    }
}
