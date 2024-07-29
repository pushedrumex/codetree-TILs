import java.util.*;
import java.io.*;

public class Main {
    static boolean[] loop;
    static int[] move;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        loop = new boolean[n+1];
        move = new int[n+1];
        visited = new boolean[n+1];
        for (int i=0;i<n;i++) {
            int next = Integer.parseInt(br.readLine());
            move[i+1] = next;
        }
        for (int i=1;i<=n;i++) {
            if (loop[i] == false) {
                visited[i] = true;
                loop[i] = dfs(i);
                visited[i] = false;
            }
        }
        int answer = 0;
        for (int i=1;i<=n;i++) {
            if (loop[i] == false) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean dfs(int i) {
        int next = move[i];
        if (next == 0) {
            return false;
        }
        if (visited[next] == true) {
            return true;
        }
        visited[next] = true;
        boolean isLoop = dfs(next);
        loop[next] = isLoop;
        visited[next] = false;
        return isLoop;
    }
}