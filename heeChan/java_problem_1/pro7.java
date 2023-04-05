import java.util.Random;

public class pro7 {
    public static void main(String args[]){
        int []arr=new int[10];
        Random rand=new Random();
        for(int i=0;i<10;i++){
            arr[i]=rand.nextInt(10)+1;
        }
        System.out.print("랜덤한 정수들 : ");
        double sum=0;
        for(int i:arr){
            System.out.print(i+" ");
            sum=sum+i;
        }
        System.out.println("\n평균은 "+sum/10);
    }
}
