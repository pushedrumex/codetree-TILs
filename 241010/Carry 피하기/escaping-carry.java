import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static int answer = 0;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int i, int sum, int count) {
        answer = Math.max(answer, count);

        if (i == n) {
            return;
        }

        for (int j=i;j<n;j++) {
            // 선택 가능한 숫자라면 선택
            if (isNotCarry(sum, nums[j])) {
                dfs(j+1, sum + nums[j], count+1);
            }
            dfs(j+1, sum, count);
        }
    }

    static boolean isNotCarry(int n1, int n2) {
        if (n1 == 0 || n2 == 0) return true;
        if (n1 % 10 + n2 % 10 > 9) return false;
        return isNotCarry(n1 / 10, n2 / 10);
    }
}