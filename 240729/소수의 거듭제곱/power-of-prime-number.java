import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int max = (int)Math.pow(b, 0.5);

        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i=2;i<=max;i++) {
            if (isPrime[i] == true) {
                for (int j=i*2;j<=max;j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        long answer = 0;
        for (int i=2;i<=max;i++) {
            if (!isPrime[i]) {
                continue;
            }

            long j = i * i;
            while (j < b) {
                if (j >= a && j <= b) {
                    answer++;
                }
                j *= i;
            }
        }
        System.out.println(answer);
    }
}