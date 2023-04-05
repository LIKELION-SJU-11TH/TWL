import java.util.Scanner;

public class pro4 {
    public  static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        System.out.print("달을 입력하세요(1~12)>>");
        int num=scan.nextInt();
        if(num==12||num==1||num==2){
            System.out.println("겨울");
        }
        else if(num==3||num==4||num==5){
            System.out.println("봄");
        }
        else if (num==6||num==7||num==8){
            System.out.println("여름");
        }
        else if(num==9||num==10||num==11){
            System.out.println("가을");
        }
        else
            System.out.println("잘못입력");
    }
}
