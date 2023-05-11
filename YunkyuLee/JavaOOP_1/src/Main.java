import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("도형의 종류를 입력하세요 (r: 직사각형, c: 원): ");
        String shape = scanner.nextLine();

        if (shape.equals("r")) {
            System.out.println("가로와 세로의 길이를 입력하세요: ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            Rectangle rec = new Rectangle(width, height);
            System.out.println("직사각형의 넓이: " + rec.getArea());
        }

        else if (shape.equals("c")) {
            System.out.println("반지름을 입력하세요: ");
            int r = scanner.nextInt();
            Circle cir = new Circle(r);
            System.out.println("원의 넓이: " + cir.getArea());
        }
    }
}