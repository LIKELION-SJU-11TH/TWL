package basic;

import java.util.Objects;
import java.util.Scanner;

public class basic5 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        float num1 = scanner.nextInt();
        String operator = scanner.next();
        float num2 = scanner.nextInt();


//        if (Objects.equals(operator, "+")) {
//            System.out.println(num1 + num2);
//        } else if (Objects.equals(operator, "-")) {
//            System.out.println(num1 - num2);
//        } else if (Objects.equals(operator, "/")) {
//            if (num2 == 0) {
//                    System.out.println("0으로 나눌 수 없습니다");
//                    break;
//                }
//            System.out.println(num1 / num2);
//        } else if (Objects.equals(operator, "*")) {
//            System.out.println(num1 * num2);
//        }

        switch (operator) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다");
                    break;
                }
                System.out.println(num1 / num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
        }
    }
}
