import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NikitaQueries {
    public static List<Integer> specialXor(int N, int Q, int[] a, int[][] query) {
        int totalXor = 0;
        for (int x : a) {
            totalXor ^= x;
        }

        int[] pre = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pre[i] = pre[i - 1] ^ a[i - 1];
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            int l = query[i][0];
            int r = query[i][1];
            int inside = pre[r] ^ pre[l - 1];
            ans.add(totalXor ^ inside);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int[][] query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        List<Integer> answers = specialXor(N, Q, a, query);
        for (int value : answers) {
            System.out.println(value);
        }

        sc.close();
    }
}
