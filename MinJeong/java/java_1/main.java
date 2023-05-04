package java_1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("도형의 종류를 입력하세요 (r: 직사각형, c: 원): ");
        String shape = sc.nextLine();

        if (shape.equals("r")) {      // 직사각형
            System.out.print("가로와 세로의 길이를 입력하세요: ");
            int w = sc.nextInt();
            int h = sc.nextInt();
            Rectangle rect = new Rectangle(w, h);
            System.out.print("직사각형의 넓이: " + rect.getArea());
        }

        else if (shape.equals("c")){
            System.out.print("반지름을 입력하세요: ");
            int r = sc.nextInt();
            Circle c = new Circle(r);
            System.out.print("원의 넓이: " + c.getArea());
        }
    }
}
