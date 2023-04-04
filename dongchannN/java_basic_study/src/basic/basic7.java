package basic;

import java.util.Arrays;

public class basic7 {
    public void solution() {
        int[] randArr = new int[10];

        float sum = 0;
        for (int i = 0; i < 10; i++) {
            randArr[i] = (int) (Math.random() * 10 + 1);
            sum += (float) randArr[i];
            System.out.print(randArr[i] + " ");
        }

        float avg = sum / 10;
        System.out.println();
        System.out.println(avg);

    }
}
