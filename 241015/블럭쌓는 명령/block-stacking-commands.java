import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] block = new int[N+1]; // 누적합
        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            block[start]++;
            block[end+1]--;
        }

        for (int i=1;i<N;i++) {
            block[i] += block[i-1];
        }

        Arrays.sort(block);
        System.out.println(block[N/2+1]);
        // 여기에 코드를 작성해주세요.
    }
}