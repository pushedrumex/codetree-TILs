import java.util.*;
import java.io.*;

public class Main {
    static int MAX_VALUE = 100_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Node> dq = new ArrayDeque<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            int point = Integer.parseInt(st.nextToken());
            visited.put(point, true);
            dq.addLast(new Node(point, 0, -1));
            dq.addLast(new Node(point, 0, 1));
        }

        int answer = 0;
        while (k > 0) {
            Node node = dq.removeFirst();
            int _point = node.point + node.dp;
            if (_point > MAX_VALUE || _point < -MAX_VALUE) continue;
            if (visited.containsKey(_point)) continue;
            answer += node.dist+1;
            visited.put(_point, true);
            dq.addLast(new Node(_point, node.dist+1, node.dp));
            k--;
        }

        System.out.println(answer);
    }

    static class Node {
        int point, dist, dp;
        Node (int point, int dist, int dp) {
            this.point = point;
            this.dist = dist;
            this.dp = dp;
        }
    }
}