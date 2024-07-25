import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Number> dq = new ArrayDeque<>();
        for (int i=0;i<n;i++) {
            dq.add(new Number(Integer.parseInt(st.nextToken()), i)); 
        }

        int count = 0;
        while (!dq.isEmpty()) {
            Number first = dq.removeFirst();
            boolean existBig = false;
            for (Number number: dq) {
                if (first.n < number.n) {
                    dq.addLast(first);
                    existBig = true;
                    break;
                }
            }
            if (existBig == false) {
                count++;
                if (first.idx == x) {
                    System.out.println(count);
                    break;
                }
            }
        }
        // 여기에 코드를 작성해주세요.
    }

    static class Number {
        int n;
        int idx;
        Number(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}