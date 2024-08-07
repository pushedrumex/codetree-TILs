import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (b-a == 1) {
            answer = 1;
        } else if (b-a == 2) {
            answer = 2;
        } else {
            a++;
            b--;
            int[] dx = {-1, 0, 1};
            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.add(new Node(a, 1, 2));
            while (!dq.isEmpty()) {
                Node node = dq.removeFirst();
                for (int d: dx) {
                    if (node.x+d <= 0) continue;
                    int _a = node.a + (node.x+d);
                    if (_a == b) {
                        answer = node.turn;
                        break;
                    }
                    dq.add(new Node(_a, node.x+d, node.turn+1));
                }
            }

        }

        System.out.println(answer);
    }

    static class Node {
        int a;
        int x;
        int turn;
        Node(int a, int x, int turn) {
            this.a = a;
            this.x = x;
            this.turn = turn;
        }
    }
}