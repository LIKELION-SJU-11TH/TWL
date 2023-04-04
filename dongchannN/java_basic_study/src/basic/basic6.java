package basic;

import java.util.Arrays;

public class basic6 {
    public void solution() {
        int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};

        for (int[] arr : n) {
            for (int elements : arr) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }

}
