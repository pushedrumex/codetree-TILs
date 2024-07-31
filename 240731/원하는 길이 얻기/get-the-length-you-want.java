import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Rod[] rods = new Rod[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            int l = Integer.parseInt(st.nextToken());
            if (l % 10 == 0) {
                rods[i] = new Rod(l/10-1, l/10);
            } else {
                rods[i] = new Rod(l/10, l/10);
            }
        }
        Arrays.sort(rods, (o1, o2) -> {
            if (o1.cut != o2.cut) {
                return o1.cut - o2.cut;
            }
            return o2.count-o1.count;
        });
        int answer = 0;
        for (Rod rod: rods) {
            if (rod.cut <= m) {
                m -= rod.cut;
                answer += rod.count;
            } else {
                answer += m;
                break;
            }
        }
        System.out.println(answer);
    }

    static class Rod {
        int cut;
        int count;
        Rod(int cut, int count) {
            this.cut = cut;
            this.count = count;
        }
    }
}