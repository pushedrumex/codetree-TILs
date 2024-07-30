import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Work[] works = new Work[n+1];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            works[i+1] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] dp = new int[n+1];
        if (works[n].t == 1) {
            dp[n] = works[n].p;
        }
        for (int i=n-1;i>0;i--) {
            int t = works[i].t;
            int p = works[i].p;

            if (i+t-1 > n) {
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.max(dp[i+1], dp[i+t-1] + p);
        }
        System.out.println(dp[1]);
    }

    static class Work {
        int t, p;
        Work(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}