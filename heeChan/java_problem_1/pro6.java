import java.util.*;
public class pro6 {
    public static void main(String arg[]){
        int n[][]={{1},{1,2,3},{1},{1,2,3,4},{1,2}};
        for(int i=0;i<5;i++){
            for(int j: n[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
