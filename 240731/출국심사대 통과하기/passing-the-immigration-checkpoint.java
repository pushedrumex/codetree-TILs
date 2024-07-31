import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Wait[] waits = new Wait[N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            waits[i] = new Wait(a, t);
        }
        Arrays.sort(waits, (o1, o2) -> o1.arrive-o2.arrive);
        int now = 1;
        for (Wait wait: waits) {
            if (now <= wait.arrive) {
                now = wait.arrive + wait.time;
            } else {
                now += wait.time;
            }
        }
        System.out.println(now);
    }

    static class Wait {
        int arrive;
        int time;
        Wait(int arrive, int time) {
            this.arrive = arrive;
            this.time = time;
        }
    }
}