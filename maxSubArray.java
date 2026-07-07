import java.util.Scanner;
public class maxSubArray {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int Sum = array[0];
        int maxSum = array[0];
        for(int i=1;i<array.length;i++){
            Sum = Math.max(array[i],Sum+array[i]);
            maxSum = Math.max(maxSum,Sum);
        }
        System.out.println(maxSum);
        sc.close();
    }
}
