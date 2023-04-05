# Java 1주차 문제

### 1번

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2자리 정수 입력(10~99) >>");
        int num = scanner.nextInt();
        int a = num / 10;
        int b = num % 10;
        if (a == b)
        {
            System.out.print("Yes! 10 자리와 1의 자리가 같습니다.");
        }
    }
}
```

### 2번

```java
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력하시오>>");
        int money = scanner.nextInt();
        System.out.println("50000원 "+money/50000+"매");
        money = money % 50000;
        System.out.println("10000원 "+money/10000+"매");
        money = money % 10000;
        System.out.println("1000원 "+money/1000+"매");
        money = money % 1000;
        System.out.println("100원 "+money/100+"매");
        money = money % 100;
        System.out.println("50원 "+money/50+"매");
        money = money % 50;
        System.out.println("10원 "+money/10+"매");
        money = money % 10;
        System.out.println("1원 "+money+"매");
    }
}
```

### 3번

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
       Scanner scanner = new Scanner(System.in);
       double x_1, y_1, r1, x_2, y_2, r2;
       System.out.print("첫번 째 원의 중심과 반지름 : ");
       x_1 = scanner.nextInt();
       y_1 = scanner.nextInt();
       r1 = scanner.nextInt();
       System.out.print("두번 째 원의 중심과 반지름 : ");
       x_2 = scanner.nextInt();
       y_2 = scanner.nextInt();
       r2 = scanner.nextInt();
       double result = Math.sqrt(Math.pow(x_1 - x_2, 2) + Math.pow(y_1 - y_2, 2));
       if (r1 + r2 > result)
       {
           System.out.println("두 원은 겹친다");
       }
    }
}
```

### 4번

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("달을 입력하세요(1~12) >>");
       int month = scanner.nextInt();
       switch(month/3)
       {
           case 0:
               System.out.print("겨울");
               break;
           case 1:
               System.out.print("봄");
               break;
           case 2:
               System.out.print("여름");
               break;
           case 3:
               System.out.print("가을");
               break;
           case 4:
               System.out.print("겨울");
               break;
           default:
               break;
       }
    }
}
```

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("달을 입력하세요(1~12) >>");
       int month = scanner.nextInt();
       int k = month / 3;
       if (k == 0 || k == 4)
           System.out.print("겨울");
       else if (k == 1)
           System.out.print("봄");
       else if (k == 2)
           System.out.print("여름");
       else if (k == 3)
           System.out.print("가을");
    }
}
```

### 5번

```java
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.print("연산 >>");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String operator = scanner.next();
        int num2 = scanner.nextInt();
        int result = 0;
        if (operator.equals("+"))
        {
            result = num1 + num2;
        }
        else if (operator.equals("-"))
        {
            result = num1 - num2;
        }
        else if (operator.equals("/"))
        {
            result = num1 / num2;
        }
        else if (operator.equals("*"))
        {
            result = num1 * num2;
        }
        System.out.print(num1 + operator + num2 + "의 연산결과는 " + result);
    }
}
```

```java
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.print("연산 >>");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String operator = scanner.next();
        int num2 = scanner.nextInt();
        int result = 0;
        switch(operator)
        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

        }
        System.out.print(num1 + operator + num2 + "의 연산결과는 " + result);
    }
}
```

### 6번

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        int n [][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
        for (int[] a : n)
        {
            for(int b : a)
            {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
```

### 7번

```java
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        int []n = new int[10];
        double sum = 0;
        for(int k : n)
        {
            k = (int) (Math.random() * 10 + 1);
            sum = sum + (double)k;
        }
        System.out.printf("평균 : %.1f",sum/10);
    }
```

### 8번

```java
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 몇개? >>");
        int n = scanner.nextInt();
        int []arr = new int[n];
        int []answer = new int[n];
        for (int i = 0; i < n; i++)
        {
            int num = (int)(Math.random ()*100 + 1);
            if(Arrays.binarySearch(arr, num) < 0)
            {
                answer[i] = num;
                arr[i] = num;
                Arrays.sort(arr);
            }
            else
                i--;
        }
        System.out.println(Arrays.toString(answer));
    }
}
```

```java
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 몇개? >>");
        int n = scanner.nextInt();
        int []check = new int[100];
        int []arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            int num = (int)(Math.random ()*100 + 1);
            if (check[num + 1] == 0)
            {
                arr[i] = num;
            }
            else
                i--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
```