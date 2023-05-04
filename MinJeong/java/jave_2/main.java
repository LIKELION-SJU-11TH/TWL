package jave_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User("5678", "민정2");

        Scanner sc = new Scanner(System.in);
        String id1 = sc.nextLine();
        String name1 = sc.nextLine();

        user1.setId(id1);
        user1.setName(name1);

        System.out.println(user1.getId() + user1.getName());
        System.out.println(user2.getId() + user2.getName());
    }
}
