import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for (int i=0;i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i=0;i<=N-3;i++) {
            for (int j=0;j<=N-3;j++) {
                int sum = 0;
                for (int _i=i;_i<i+3;_i++) {
                    for (int _j=j;_j<j+3;_j++) {
                        sum += graph[_i][_j];
                    }
                }
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}