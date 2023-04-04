package basic;

import java.util.Scanner;

public class basic8 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            int randNum = (int) (Math.random() * 100 + 1);
            while (checkArr(randNum, arr)) {
                randNum =(int) (Math.random() * 100 + 1);
            }
            arr[i] = randNum;
            System.out.print(arr[i] + " ");
        }
    }

    public boolean checkArr(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
