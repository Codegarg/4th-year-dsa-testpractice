import java.util.HashMap;
import java.util.Scanner;

public class SubArraySumequalsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for (int value : arr) {
            prefixSum += value;
            int needed = prefixSum - k;
            if (map.containsKey(needed)) {
                count += map.get(needed);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);
        sc.close();
    }
}
