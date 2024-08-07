import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] cmds = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayDeque<String> dq = new ArrayDeque<>();
        for (int i=0;i<n;i++) {
            dq.add(st.nextToken());
        }

        boolean reverse = false;
        for (String cmd: cmds) {
            if (cmd.equals("R")) {
                reverse = !reverse;
            } else if (cmd.equals("D")) {
                if (dq.size() == 0) {
                    System.out.println("error");
                    return;
                }
                if (reverse == true) {
                    dq.removeLast();
                } else {
                    dq.removeFirst();
                }
            }
        }

        if (reverse == true) {
            String answer = "";
            while (!dq.isEmpty()) {
                answer += dq.removeLast() + " ";
            }
            System.out.println(answer);
        } else {
            System.out.println(String.join(" ", dq));
        }
    }
}