import java.util.*;
import java.io.*;

// 돌을 버리거나(Y), 추가하거나(X), 옮겨서(abs(i-j)*Z)
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int[] stones = new int[N];
        int[] goal = new int[N];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            stones[i] = Integer.parseInt(st.nextToken());
            goal[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i=0;i<N-1;i++) {
            int need = goal[i] - stones[i];
            if (need == 0) continue;
            for (int j=i+1;j<N;j++) {
                if (need == 0) break;
                int _need = goal[j] - stones[j];
                if (need > 0 && _need < 0) {
                    int move = Math.min(need, -_need);
                    // 옮기는 비용이 추가하는 비용보다 적다면
                    if (move*(j-i)*Z < move*X) {
                        answer += move*(j-i)*Z;
                        stones[i] += move;
                        stones[j] -= move;
                        need -= move;
                    }
                } else if (need < 0 && _need > 0) {
                    int move = Math.min(-need, _need);
                    // 옮기는 비용이 제거하는 비용보다 적다면
                    if (move*(j-i)*Z < move*Y) {
                        answer += move*(j-i)*Z;
                        stones[i] -= move;
                        stones[j] += move;
                        need += move;
                    }
                }
            }
        }
        for (int i=0;i<N;i++) {
            int need = goal[i] - stones[i];
            if (need > 0) answer += X * need;
            else answer += Y * (-need)
        }
        System.out.println(answer);
    }
}