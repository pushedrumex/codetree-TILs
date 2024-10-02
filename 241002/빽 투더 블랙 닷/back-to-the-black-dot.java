import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int answer = Integer.MAX_VALUE;
    static int[] redNums;
    static boolean[] visited;
    static int K;
    static int[][] redDistance;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        redNums = new int[K];
        redDistance = new int[N+1][N+1];
        for (int i=0;i<K;i++) {
            int red = Integer.parseInt(br.readLine());
            redNums[i] = red;
        }

        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        // 빨간점 -> 모든점 다익스트라
        for (int n: redNums) {
            dijkstra(n, redDistance[n]);
        }

        // 빨간점 순열, 백트래킹
        for (int red: redNums) {
            visited[red] = true;
            dfs(red, 1, 0);
            visited[red] = false;
        }

        System.out.println(answer * 2);
    }

    static void dfs(int now, int count, int distance) {
        if (count == K) {
            answer = Math.min(answer, distance);
            return;
        }
        for (int next: redNums) {
            if (visited[next] == false) {
                visited[next] = true;
                dfs(next, count+1, distance+redDistance[now][next]);
            }
        }

    }

    static void dijkstra(int start, int[] distance) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.n - o2.n);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (distance[node.n] < node.distance) continue;
            for (Node next:graph[node.n]) {
                int d = node.distance + next.distance;
                if (d < distance[next.n]) {
                    distance[next.n] = d;
                    pq.add(new Node(next.n, d));
                }
            }
        }

    }

    static class Node {
        int n;
        int distance;
        Node(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }
}