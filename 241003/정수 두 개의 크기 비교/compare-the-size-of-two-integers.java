import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        long answer = 0;
        for (int i=1;i<n;i++) {
            answer += i-bs(i);
        }
        System.out.println(answer);
    }

    static int bs(int i) {
        int answer = i;
        int left = 0;
        int right = i-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= (float)nums[i] * 0.9) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}