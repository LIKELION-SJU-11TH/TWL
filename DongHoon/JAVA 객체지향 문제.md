# JAVA 객체지향 문제

1. 

```java
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("도형의 종류를 입력하세요 (r: 직사각형, c: 원): ");
        String shape = scanner.nextLine();
        if (Objects.equals(shape, "r"))
        {
            Rectangle rec = new Rectangle();
            System.out.println("가로와 세로의 길이를 입력하세요 : ");
            rec.setHeight(scanner.nextDouble());
            rec.setWidth(scanner.nextDouble());
            System.out.println("직사각형 넓이 : " + rec.getArea());
        }
        else if (Objects.equals(shape, "c"))
        {
            Circle cir = new Circle();
            System.out.println("반지름의 길이를 입력하세요 : ");
            cir.setRadius(scanner.nextDouble());
            System.out.println("직사각형 넓이 : " + cir.getArea());
        }
    }
}
```

```java
public abstract class Shape {
    public abstract double getArea();
}
```

```java
public class Rectangle extends Shape {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }

    public void setWidth(double width) {
        this.width = width;

    }

    public void setHeight(double height) {
        this.height = height;
    }
}
```

```java
public class Circle extends Shape {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2);
    }
}
```

2.

```java
public class User {
    private String name;
    private int age;
    private int id;
    User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
```

```java
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        User obj1 = new User("asd", 23, 24);
        User obj2 = new User("park", 497, 24);
        System.out.println(obj1.getName());
        System.out.println(obj1.getId());
        System.out.println(obj1.getAge());

        System.out.println("===============================");
        System.out.println(obj2.getName());
        System.out.println(obj2.getId());
        System.out.println(obj2.getAge());

    }
}
```