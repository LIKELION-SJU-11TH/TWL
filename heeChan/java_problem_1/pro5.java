import java.util.Scanner;

public class pro5 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        String s=scan.next();
        int y=scan.nextInt();
//        if(s.equals("+")){
//            System.out.println(x+y);
//        }
//        else if(s.equals("-")){
//            System.out.println(x-y);
//        }
//        else if(s.equals("*")){
//            System.out.println(x-y);
//        }
//        else if(s.equals("/")){
//            if(y==0){
//                System.out.println("0으로 나눌 수 없습니다.");
//            }
//            else
//                System.out.println(x/y);
//        }
        switch(s){
            case "+":
                System.out.println(x+y);
                break;
            case "-":
                System.out.println(x-y);
                break;
            case "*":
                System.out.println(x*y);
                break;
            case "/":
                if(y==0){
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                else {
                    System.out.println(x / y);
                }
                break;

        }
    }
}
