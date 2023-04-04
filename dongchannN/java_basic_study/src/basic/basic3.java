package basic;

import java.util.Scanner;
import java.util.stream.Stream;

public class basic3 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String exp1 = scanner.nextLine();
        int[] circle1 = Stream.of(exp1.split(" ")).mapToInt(Integer::parseInt).toArray();
        String exp2 = scanner.nextLine();

        int[] circle2 = Stream.of(exp2.split(" ")).mapToInt(Integer::parseInt).toArray();


        double distanceXpow = Math.pow(circle1[0] - circle2[0],2);
        double distanceYpow = Math.pow(circle1[1] - circle2[1],2);

        double distance = Math.sqrt(distanceXpow + distanceYpow);

        System.out.println(distance);
        System.out.println(circle1[2] + circle2[2]);

        if (distance < circle1[2] + circle2[2]) {
            System.out.println("두 원은 서로 겹친다");
        } else if (distance == circle1[2] + circle2[2]) {
            System.out.println("두 원은 붙어있다.");
        } else System.out.println("서로 겹쳐있지 않다.");

    }
}
