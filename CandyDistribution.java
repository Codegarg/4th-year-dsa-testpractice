import java.util.Arrays;
import java.util.Scanner;

public class CandyDistribution {
    public static int candy(int[] ratings) {
        int n = ratings.length;

        if (n == 0) {
            return 0;
        }

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of children: ");
        int n = scanner.nextInt();

        int[] ratings = new int[n];
        System.out.println("Enter ratings:");
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        int result = candy(ratings);
        System.out.println("Minimum candies needed: " + result);

        scanner.close();
    }
}
