package basic;

import java.util.Scanner;

public class basic1 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int num10 = input / 10;
        int num1 = input % 10;

        if (num10 == num1) {
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        } else System.out.println("NO! 다릅니다.");
    }
}
