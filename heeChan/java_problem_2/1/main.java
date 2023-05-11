package practice;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("r은 직사각형 c는 원 골라:");
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        if(s.charAt(0)=='r'){
            int x= scan.nextInt();
            int y=scan.nextInt();
            Rectangle rectangle=new Rectangle(x,y);
            System.out.println(rectangle.getArea());
        }
        else{
            int r=scan.nextInt();
            Circle circle=new Circle(r);
            System.out.println(circle.getArea());
        }

    }
}
