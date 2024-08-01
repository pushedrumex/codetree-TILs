import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(1, 0, 0));
        boolean[][] visited = new boolean[10000][10000];
        visited[1][0] = true;

        while (!dq.isEmpty()) {
            Node node = dq.removeFirst();
            int a = node.a;
            int b = node.b;
            int count = node.count;
            if (a == s) {
                System.out.println(count);
                break;
            }
            if (b > 0 && !visited[a+b][b]) {
                visited[a+b][b] = true;
                dq.add(new Node(a+b, b, count+1));
            }
            if (a > 1 && !visited[a-1][b]) {
                visited[a+b][b] = true;
                dq.add(new Node(a-1, b, count+1));
            }
            if (!visited[a][a]) {
                visited[a][a] = true;
                dq.add(new Node(a, a, count+1));
            }
        }

    }
    static class Node {
        int a;
        int b;
        int count;
        Node(int a, int b, int count) {
            this.a = a;
            this.b = b;
            this.count = count;
        }
    }
}