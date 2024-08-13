import java.util.*;
import java.io.*;

public class Main {
    static Node[] nodes;
    static int n;
    static int answer = 0;
    static HashSet<Integer> xVisited = new HashSet();
    static HashSet<Integer> yVisited = new HashSet();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int line, int i) {
        if (answer != 0) return;
        if (i == n) {
            answer = 1;
            return;
        }
        if (line > 3) return;
        Node node = nodes[i];
        int x = node.x;
        int y = node.y;
        // 이미 지난 점
        if (xVisited.contains(x) || yVisited.contains(y)) {
            dfs(line, i+1);
        }
        // x점
        xVisited.add(x);
        dfs(line+1, i+1);
        xVisited.remove(x);
        // y점
        yVisited.add(y);
        dfs(line+1, i+1);
        yVisited.remove(y);
    }
    static class Node {
        int x, y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}