import java.util.Scanner;

public class maxSubarraybrute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < array.length; j++) {
                currentSum += array[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        System.out.println(maxSum);
        sc.close();
    }
}
