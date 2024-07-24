import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = factori(n) / factori(m) / factori(n-m);
        System.out.println(answer);
        // 여기에 코드를 작성해주세요.
    }

    static int factori(int n) {
        int result = 1;
        for (int i=1;i<=n;i++) {
            result *= i;
        }
        return result;
    }
}