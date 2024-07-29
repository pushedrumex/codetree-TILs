import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 여기에 코드를 작성해주세요.
        long answer = n;
        for (int i=2;i<=m;i++) {
            answer = answer * (n-i+1) / i;
        }
        System.out.println(answer);
    }
}