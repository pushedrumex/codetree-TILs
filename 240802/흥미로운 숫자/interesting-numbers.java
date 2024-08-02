import java.util.*;
import java.io.*;

public class Main {
    static int Y;
    static int X;
    static int[] count = new int[10];
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(long num) {
        if (num > Y) return;
        int overOne = 0;
        int type = 0;
        for (int c: count) {
            if (c > 1) overOne++;
            if (c > 0) type++;
            if (overOne >= 2) return;
            if (type > 2) return;
        }

        if (type == 2 && X <= num) answer++;
        for (int i=0;i<10;i++) {
            if (num == 0 && i == 0) continue;
            count[i]++;
            dfs(num*10+i);
            count[i]--;
        }
    }
}