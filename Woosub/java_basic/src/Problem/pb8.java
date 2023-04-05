package Problem;

import java.util.Scanner;

public class pb8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 몇개?");
        int word_cnt = scanner.nextInt();

        int num_array[] = new int[word_cnt];
        for (int i = 0; i < word_cnt; i++){
            int rand_num = (int)(Math.random() * 100 + 1);
            boolean flag = false;    // 중복 여부 체크
            for (int j = 0; j < i; j++)
            {
                if(rand_num == num_array[j]){
                    i--;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                num_array[i] = rand_num;
            }
        }

        int cnt = 0;
        for (int e : num_array){
            System.out.print(e + " ");
            cnt++;
            if(cnt % 10 == 0)
                System.out.println();
        }
    }
}
