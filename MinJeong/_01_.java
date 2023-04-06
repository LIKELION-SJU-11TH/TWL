package JAVA;

import java.util.Scanner;

public class _01_ {
    // 2번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num;
//        System.out.print("2자리수 정수 입력(10~99)>>");
//        num = sc.nextInt();
//
//        if (num / 10 == num % 10) System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
//        else System.out.println("No!");
//    }

    // 3번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("금액을 입력하시오>>");
//        int money = sc.nextInt();
//        // System.out.printf("money = %d", money);
//
//        int[] change = {50000, 10000, 1000, 500, 100, 50, 10, 1};
//        int[] changeCnt = {0, 0, 0, 0, 0, 0, 0, 0};
//        String[] s_change = {"오만원권", "만원권", "천원권", "오백원", "백원", "오십원", "십원", "일원"};
//
//        for (int i = 0; i < change.length; i++){
//            changeCnt[i] += money / change[i];
//            money %= change[i];
//        }
//        for (int i = 0; i < change.length; i++) {
//            if (changeCnt[i] != 0 && i <= 2)
//                System.out.println(s_change[i] + " " + changeCnt[i] + "매");
//            else if (changeCnt[i] != 0)
//                System.out.println(s_change[i] + " " + changeCnt[i] + "개");
//        }
//    }

    // 10번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("첫번째 원의 중심과 반지름 입력>>");
//        int c1_x, c1_y, r1;
//        c1_x = sc.nextInt();
//        c1_y = sc.nextInt();
//        r1 = sc.nextInt();
//
//        System.out.print("두번째 원의 중심과 반지름 입력>>");
//        int c2_x, c2_y, r2;
//        c2_x = sc.nextInt();
//        c2_y = sc.nextInt();
//        r2 = sc.nextInt();
//
//        double distance = Math.sqrt((c2_x - c1_x)*(c2_x - c1_x) + (c2_y - c1_y)*(c2_y - c1_y));
//        if (distance < r1) System.out.println("두 원은 서로 겹친다.");
//        else System.out.println("두 원은 서로 겹치치 않는다.");
//    }


    // 11번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("달을 입력하세요(1~12)>>");
//        int month = sc.nextInt();
//
//        // if-else 문
//        /*if (month >= 3 && month <= 5) System.out.println("봄");
//        else if (month >= 6 && month <= 8) System.out.println("여름");
//        else if (month >= 9 && month <= 11) System.out.println("가을");
//        else if (month == 12 && month ==1 && month == 2) System.out.println("겨울");
//        else System.out.println("잘못입력");*/
//
//        // switch 문
//        switch (month){
//            case 1: System.out.println("겨울"); break;
//            case 2: System.out.println("겨울"); break;
//            case 3: System.out.println("봄"); break;
//            case 4: System.out.println("봄"); break;
//            case 5: System.out.println("봄"); break;
//            case 6: System.out.println("여름"); break;
//            case 7: System.out.println("여름"); break;
//            case 8: System.out.println("여름"); break;
//            case 9: System.out.println("가을"); break;
//            case 10: System.out.println("가을"); break;
//            case 11: System.out.println("가을"); break;
//            default: System.out.println("잘못입력");
//        }
//    }


    // 12번
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        System.out.print("연산>>");
//        String operator;
//        float num1, num2;
//        num1 = sc.nextInt();
//        operator = sc.next();
//        num2 = sc.nextInt();
//
//        float result = 0;
//        // if-else 문
//        /*if (operator.equals("+")) result = num1 + num2;
//        else if (operator.equals("-")) result = num1 - num2;
//        else if (operator.equals("*")) result = num1 * num2;
//        else if (operator.equals("/")) {
//            if (num2 == 0){
//                System.out.println("0으로 나눌 수 없습니다.");
//                System.exit(0);
//            }
//            result = num1 / num2;
//        }*/
//
//        // switch 문
//        switch (operator){
//            case "+": result = num1 + num2; break;
//            case "-": result = num1 - num2; break;
//            case "*": result = num1 * num2; break;
//            case "/":
//                if (num2 == 0) {
//                    System.out.println("0으로 나눌 수 없습니다.");
//                    System.exit(0);
//                }
//                result = num1 / num2;
//                break;
//        }
//
//        System.out.printf("%.0f%s%.0f의 계산 결과는 %.0f", num1, operator, num2, result);
//    }


    // 2번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n [][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
//
//        for (int i = 0; i < n.length; i++){
//            for (int j = 0; j < n[i].length; j++)
//                System.out.print(n[i][j] + " ");
//            System.out.println();
//        }
//    }

    // 7번
//    public static void main(String[] args) {
//        int[] arr = new int[10];
//
//        float sum = 0f;
//        for (int i = 0; i < 10; i++){
//            arr[i] = (int)(Math.random() * 10 + 1);
//            sum += arr[i];
//        }
//        System.out.print("랜덤한 정수들 :");
//        for (int i = 0; i < 10; i++) System.out.print(" " + arr[i]);
//        System.out.println("평균은 " + sum / 10);
//    }


    // 8번
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("정수 몇개?");
//        int cnt = sc.nextInt();
//
//        int[] arr = new int[cnt];
//        for (int i = 0; i < cnt; i++){
//            arr[i] = (int)(Math.random() * 100 + 1);
//
//            for (int j = 0; j < i; j++)
//                if (arr[i] == arr[j]) arr[i] = (int)(Math.random() * 100 + 1);
//        }
//
//        for (int j = 0; j < cnt; j++) {
//            if (j > 9 && j % 10 == 0) System.out.println();
//            System.out.print(arr[j] + " ");
//        }
//    }
}

