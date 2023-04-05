package Problem;

import java.util.Scanner;

public class pb5 {
    public static void main(String[] args){
        System.out.print("연산>>");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String operator = scanner.next();
        int b = scanner.nextInt();

        if(operator.equals("+")){
            System.out.print(a + operator + b + "의 계산 결과는 ");
            System.out.println(a + b);
        }
        else if(operator.equals("-")){
            System.out.print(a + operator + b + "의 계산 결과는 ");
            System.out.println(a - b);
        }
        else if(operator.equals("*")){
            System.out.print(a + operator + b + "의 계산 결과는 ");
            System.out.println(a * b);
        }
        else if(operator.equals("/")){
            if(b != 0){
                System.out.print(a + operator + b + "의 계산 결과는 ");
                System.out.println(a / b);
            }
            else{
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }
    }
}
