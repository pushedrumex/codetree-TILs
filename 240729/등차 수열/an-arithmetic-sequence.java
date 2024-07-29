import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i=0;i<n;i++) {
            int num = nums[i];
            int count  = 0;
            if (num == a) {
                count++;
                for (int j=i+1;j<n;j++) {
                    if (nums[j] == num + d*(j-i)) {
                        count++;
                    } else {
                        break;
                    }
                }

            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
        // 여기에 코드를 작성해주세요.
    }
}