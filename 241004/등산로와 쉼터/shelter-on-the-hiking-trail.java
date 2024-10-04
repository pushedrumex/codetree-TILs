import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] height = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++) {
            height[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList();
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }

        Integer[] rests = new Integer[n];
        for (int i=0;i<n;i++) {
            rests[i] = i+1;
        }

        Arrays.sort(rests, (o1, o2) -> height[o2] - height[o1]);
        
        // 가장 높은 곳부터 내려오면서, 현재 위치로 하산할 수 있는것 중 큰값 선택
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int start: rests) {
            int max = 0;
            for (int next: graph[start]) {
                if (height[next] > height[start]) {
                    max = Math.max(max, dp[next]);
                }
            }
            dp[start] += max;
        }

        for (int i=1;i<=n;i++) {
            System.out.println(dp[i]);
        }

        // 여기에 코드를 작성해주세요.
    }
}