import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Info> infos = new ArrayList<>();
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            infos.add(new Info(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(infos, (o1, o2) -> o1.n - o2.n);

        int answer = 0;
        if (infos.get(0).type.equals("S")) {
            answer += Math.max(infos.get(0).n, A) - A;
        }
        if (infos.get(N-1).type.equals("S")) {
            answer += B - Math.min(infos.get(N-1).n, B);
        }
        for (int i=0;i<N-1;i++) {
            Info now = infos.get(i);
            Info next = infos.get(i+1);

            int s = now.n;
            int e = next.n;
            int m = (s + e) / 2;

            if (now.type.equals("S")) {
                answer += m - s + 1;
            }

            if (next.type.equals("S")) {
                answer += e - m + 1;
            }

            if (now.type.equals("S")&& next.type.equals("S")) answer--;
        }

        System.out.println(answer);
        // 여기에 코드를 작성해주세요.
    }

    static class Info {
        String type;
        int n;
        Info(String type, int n) {
            this.type = type;
            this.n = n;
        }
    }
}