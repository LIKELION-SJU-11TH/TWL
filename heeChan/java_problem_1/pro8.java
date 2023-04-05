import java.util.Random;
import java.util.Scanner;

public class pro8 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
        System.out.print("정수 몇개?");
        int n=scan.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=rand.nextInt(100)+1;
            for(int j=0;j<i;j++){
                if(arr[j]==arr[i]){
                    arr[i]=rand.nextInt(100)+1;
                }
            }

        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
