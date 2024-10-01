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
            answer += infos.get(0).n - A;
        }
        if (infos.get(N-1).type.equals("S")) {
            answer += B - infos.get(N-1).n + 1;
        }
        for (int i=0;i<N-1;i++) {
            Info now = infos.get(i);
            Info next = infos.get(i+1);
            if (now.type.equals("S") && next.type.equals("S")) {
                answer += next.n - now.n;
            } else if (now.type.equals("NS") && next.type.equals("S")) {
                answer += next.n - (now.n + next.n) / 2;
                if ((now.n + next.n) % 2 > 0) answer++;
            } else if (now.type.equals("S") && next.type.equals("NS")) {
                answer += (now.n + next.n) / 2 - now.n + 1;
            }
            // 3 4 "5" 6 7
            // 3 "4" 5 6
        }
        System.out.println(answer);
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