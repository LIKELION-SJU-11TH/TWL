## 문제 1

```java
import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("2자리수 정수 입력>>");
        int n = scanner.nextInt();

        if (n / 10 == n % 10) {
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        }

        scanner.close();
    }
}
```

## 문제 2

```java
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하시오>>");
        int money = scanner.nextInt();

        if (money / 50000 > 0) {
            System.out.println("오만원권 " + money / 50000 + "매");
            money = money % 50000;
        }

        if (money / 10000 > 0) {
            System.out.println("만원권 " + money / 10000 + "매");
            money = money % 10000;
        }

        if (money / 1000 > 0) {
            System.out.println("천원권 " + money / 1000 + "매");
            money = money % 1000;
        }

        if (money / 100 > 0) {
            System.out.println("백원 " + money / 100 + "개");
            money = money % 100;
        }

        if (money / 50 > 0) {
            System.out.println("오십원 " + money / 50 + "개");
            money = money % 50;
        }

        if (money / 10 > 0) {
            System.out.println("십원 " + money / 10 + "개");
            money = money % 10;
        }

        if (money > 0) {
            System.out.println("일원 " + money + "개");
        }

        scanner.close();
    }
}
```

## 문제 3

```java
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {

        System.out.println("첫번째 원의 중심과 반지름 입력>>");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int x1 = scanner.nextInt();
        double r = scanner.nextDouble();

        System.out.println("두번째 원의 중심과 반지름 입력>>");
        int y = scanner.nextInt();
        int y1 = scanner.nextInt();
        double r2 = scanner.nextDouble();

        double distance = 0.0;

        distance = Math.sqrt((x-x1) * (x-x1) + (y-y1) * (y-y1));

        if (distance <= r + r2) {
            System.out.println("두 원은 서로 겹친다.");
        }

        else {
            System.out.println("두 원은 서로 겹치지 않는다.");
        }

        scanner.close();
    }
}
```

## 문제 4

```java
import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("달을 입력하세요(1~12)>>");
        int month = scanner.nextInt();

        if (month >= 3 && month <= 5) {
            System.out.println("봄");
        }

        else if (month >= 6 && month <= 8) {
            System.out.println("여름");
        }

        else if (month >= 9 && month <= 11) {
            System.out.println("가을");
        }

        else if (month == 12 || month == 1 || month == 2) {
            System.out.println("겨울");
        }

        else {
            System.out.println("잘못입력");
        }

        scanner.close();
    }
}
```

## 문제 5

```java
import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1, n2, result;
        String cal;

        System.out.println("연산>>");

        n1 = scanner.nextInt();
        cal = scanner.next();
        n2 = scanner.nextInt();

        if (cal.equals("+")) {
            result = n1 + n2;
            System.out.println(n1 + cal + n2 + "의 계산 결과는 " + result);
        }

        else if (cal.equals("-")) {
            result = n1 - n2;
            System.out.println(n1 + cal + n2 + "의 계산 결과는 " + result);
        }

        else if (cal.equals("*")) {
            result = n1 * n2;
            System.out.println(n1+cal+n2+"의 계산 결과는 "+result);
        }

        else if (cal.equals("/")) {
            if (n2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
            }

            else {
                result = n1 / n2;
                System.out.println(n1+cal+n2+"의 계산 결과는 "+result);
            }
        }

        scanner.close();
    }
}
```

## 문제 6

```java
import java.util.Scanner;

public class p6 {
    public static void main(String[] args) {

        int n[][] = {{1},{1,2,3},{1},{1,2,3,4},{1,2}};

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                System.out.print(n[i][j]+"");
            }

            System.out.println();
        }
    }
}
```

## 문제 7

```java
import java.util.Scanner;

public class p7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arr[] = new int[10];
        int sum = 0;
        double ave = 0;

        System.out.print("랜덤한 정수들: ");

        for(int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random()*10 + 1);
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for(int i = 0; i < 10; i++) {
            sum += arr[i];
        }

        ave = sum / 10.0;

        System.out.println("평균은 " + ave);

        scanner.close();
    }
}
```

## 문제 8

```java
import java.util.Scanner;

public class p8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arr[];
        System.out.print("정수 몇개?>>");
        int num = scanner.nextInt();

        arr = new int[num];

        int count = 0;

        for(int i = 0; i < num; i++) {
            arr[i] = (int)(Math.random()*100 + 1);

            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
            count++;

            if(count % 10 == 0) {
                System.out.println();
            }
        }

        scanner.close();
    }
}
```
