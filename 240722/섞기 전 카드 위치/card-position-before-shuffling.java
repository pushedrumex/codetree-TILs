import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseIng(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] idx = new int[N];
        for (int i=0;i<n;i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken())
        }
        int[] newNums = new int[N];
        int count = 3;
        while (count-- > 0) {
            for (int i=0;i<N;i++) {
                newNums[idx[i]-1] = nums[i];
            }
            nums = newNums.clone();
        }
        for (int num: nums) {
            System.out.println(num);
        }
        // 여기에 코드를 작성해주세요.
    }
}