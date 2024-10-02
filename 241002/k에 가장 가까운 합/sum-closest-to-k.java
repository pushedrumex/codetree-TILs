import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        int count = 0;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int _diff = Math.abs(sum - k);
            if (_diff < diff) {
                count = 1;
                diff = _diff;
            } else if (_diff == diff) {
                count++;
            }
            if (sum < k) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}