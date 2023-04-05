package basic;

import java.util.Scanner;

public class basic4 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

//        if (3 <= num && num <= 5) {
//            System.out.println("봄");
//        } else if (6 <= num && num <= 8) {
//            System.out.println("여름");
//        } else if (9 <= num && num <= 11) {
//            System.out.println("가을");
//        } else System.out.println("겨울");

        switch (num) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
        }

    }
}
