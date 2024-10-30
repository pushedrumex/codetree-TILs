import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] graph = new int[50][50];
        graph[0][0] = 1;
        graph[1][0] = 1;
        graph[1][1] = 1;
        for (int i=2;i<50;i++) {
            for (int j=0;j<=i;j++) {
                if (j == 0 || j == i) {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = graph[i-1][j-1] + graph[i-1][j];
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int w = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i=0;i<w;i++) {
            for (int j=0;j<=i;j++) {
                answer += graph[r+i][c+j];
            }
        }

        System.out.println(answer);
    }
}