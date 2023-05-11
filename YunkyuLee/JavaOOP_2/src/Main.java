import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User("20011851","Lee");

        Scanner scanner = new Scanner(System.in);
        String id1 = scanner.next();
        String name1 = scanner.next();

        user1.setId(id1);
        user1.setName(name1);

        System.out.println(user1.getId() + " " + user1.getName());
        System.out.println(user2.getId() + " " + user2.getName());
    }
}