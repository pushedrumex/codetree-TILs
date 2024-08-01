import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int a = 1; // 화면 문자 개수
        int b = 0; // 클립 보드 문자 개수
        int answer = 0;
        for (int i=2;i<=s;i++) {
            while (true) {
                answer++;
                if (b > 0 && a + b == i) {
                    a += b;
                    break;
                } else if (a > 1 && a-1 == i) {
                    a--;
                    break;
                } else {
                    b = a;
                }
            }
        }
        System.out.println(answer);

    }
}