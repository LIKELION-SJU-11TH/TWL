package Problem;

import java.util.Scanner;

public class pb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하시오>>>");

        int total = scanner.nextInt();
        int fifty_thousand = 0;
        int ten_thousand = 0;
        int thousand = 0;
        int hundred = 0;
        int fifty = 0;
        int ten = 0;
        int one = 0;

        one = total % 10;
        total -= one * 1;

        ten = (total % 100) / 10;
        total -= ten * 10;

        fifty = ten / 5;
        ten -= fifty * 5;

        hundred = (total % 1000) / 100;
        total -= hundred * 100;

        thousand = (total % 10000) / 1000;
        total -= thousand * 1000;

        ten_thousand = total / 10000;
        fifty_thousand = ten_thousand / 5;
        ten_thousand -= fifty_thousand * 5;

//        while(total >= 50000) {
//            fifty_thousand += 1;
//            total -= 50000;
//        }
//
//        while(total >= 10000) {
//            ten_thousand += 1;
//            total -= 10000;
//        }
//
//        while(total >= 1000) {
//            thousand += 1;
//            total -= 1000;
//        }
//
//        while(total >= 100) {
//            hundred += 1;
//            total -= 100;
//        }
//
//        while(total >= 50) {
//            fifty += 1;
//            total -= 50;
//        }
//
//        while(total >= 10) {
//            ten += 1;
//            total -= 10;
//        }
//
//        while(total >= 1) {
//            one += 1;
//            total -= 1;
//        }

        System.out.println("오만원권 " + fifty_thousand + "매");
        System.out.println("만원권 " + ten_thousand + "매");
        System.out.println("천원권 " + thousand + "매");
        System.out.println("백원 " + hundred + "매");
        System.out.println("오십원 " + fifty + "매");
        System.out.println("십원 " + ten + "매");
        System.out.println("일원 " + one + "매");
    }
}
