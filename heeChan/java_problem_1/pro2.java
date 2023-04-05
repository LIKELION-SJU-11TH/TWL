import java.util.Scanner;

import static java.lang.Math.pow;

public class pro2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("금액을 입력하시오>>");
        int num=scan.nextInt();
        int money[]={50000,10000,1000,100,50,10,1};
        String str[]={"오만원권","만원권","천원권","백원","오십원","십원","일원"};
        String str1[]={"매","매","매","개","개","개","개"};
        for(int i=0;i<7;i++){
            int cnt=num/money[i];
            System.out.println(str[i]+" "+cnt+str1[i]);
            num=num-money[i]*cnt;
        }

    }
}