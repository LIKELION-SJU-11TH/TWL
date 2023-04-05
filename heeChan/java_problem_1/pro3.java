import java.util.Scanner;

import static java.lang.Math.pow;

public class pro3 {
    public static void main(String[] args) {
        System.out.print("첫번째 원의 중심과 반지름 입력>>");
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();
        System.out.print("두번째 원의 중심과 반지름 입력>>");
        int d=scan.nextInt();
        int e=scan.nextInt();
        int f=scan.nextInt();
        if(pow((b-e),2)+pow((a-d),2)<=pow((f+c),2)){
            System.out.println("두 원은 서로 겹친다");
        }
        else{
            System.out.println("두 원은 서로 겹치지 않는다");
        }
    }
}