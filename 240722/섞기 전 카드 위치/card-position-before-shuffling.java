import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] idx = new int[N];
        for (int i=0;i<N;i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] beforeNums = new int[N];

        for (int count=0;count<3;count++) {
            for (int i=0;i<N;i++) {
                beforeNums[i] = nums[idx[i]-1];
            }
            nums = beforeNums.clone();
        }
        for (int num: nums) {
            System.out.println(num);
        }
        // 여기에 코드를 작성해주세요.
    }
}