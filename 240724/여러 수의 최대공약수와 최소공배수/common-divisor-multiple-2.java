import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int cd = 0;
        for (int i=1;i<=minNum;i++) {
            boolean flag = true;
            for (int num: nums) {
                if (num % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                cd = i;
            }
        }
        int cm = 0;
        for (int i=maxNum;i<=Integer.MAX_VALUE;i++) {
            boolean flag = true;
            for (int num: nums) {
                if (i % num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                cm = i;
                break;
            }
        }
        System.out.println(cd + " " + cm);
        // 여기에 코드를 작성해주세요.
    }
}