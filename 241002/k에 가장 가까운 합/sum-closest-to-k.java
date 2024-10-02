import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> count  = new HashMap<>();
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> nums = new ArrayList<>(count.keySet());
        Collections.sort(nums);

        int left = 0;
        int right = nums.size()-1;
        int answer = 0;
        if (nums.size() == 1) answer = count.get(nums.get(0)) * (count.get(nums.get(0)) - 1) / 2;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            int _diff = Math.abs(sum - k);
            if (_diff < diff) {
                answer = count.get(nums.get(left)) * count.get(nums.get(right));
                diff = _diff;
            } else if (_diff == diff) {
                answer += count.get(nums.get(left)) * count.get(nums.get(right));
            }
            if (sum >= k) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);
        // -1 1 1 1 2 2
    }
}