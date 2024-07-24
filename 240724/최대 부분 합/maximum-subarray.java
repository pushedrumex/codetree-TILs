import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i], dp[i] + dp[i-1]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        // 여기에 코드를 작성해주세요.
    }
}