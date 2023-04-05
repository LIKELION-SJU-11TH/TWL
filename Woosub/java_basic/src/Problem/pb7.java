package Problem;

public class pb7 {
    public static void main(String[] args){
        int n[] = new int[10];
        for(int i = 0; i < 10; i++){
            n[i] = (int)(Math.random() * 10 + 1);
        }
        System.out.print("랜덤한 정수들 : ");
        for (int i = 0; i < 10; i++)
            System.out.print(n[i] + " ");
        System.out.println();
        System.out.print("평균은 " + avg(n));
    }

    static float avg(int number[]){
        float result = 0.0f;
        for (int i = 0; i < number.length; i++){
            result += number[i];
        }

        return result / number.length;
    }
}
