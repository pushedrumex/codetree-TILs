import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
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
        for (long i=2;i<=max;i++) {
            if (!isPrime[(int)i]) {
                continue;
            }

            long j = i;
            while (j < b) {
                j *= i;
                if (j >= a && j <= b) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}