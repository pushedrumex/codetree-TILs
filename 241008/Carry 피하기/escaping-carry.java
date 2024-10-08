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
        // 얻을 수 있는 최대 개수가 현재 개수 이하라면
        if (count + n - i <= answer) return;

        answer = Math.max(answer, count);

        if (i == n) {
            return;
        }

        for (int j=i;j<n;j++) {
            // 선택 가능한 숫자라면 선택
            if (isNotCarry(sum, nums[i])) {
                dfs(j+1, sum + nums[i], count+1);
            }
        }
    }

    static boolean isNotCarry(int n1, int n2) {
        if (n1 == 0 || n2 == 0) return true;
        if (n1 % 10 + n2 % 10 > 9) return false;
        return isNotCarry(n1 / 10, n2 / 10);
    }
}