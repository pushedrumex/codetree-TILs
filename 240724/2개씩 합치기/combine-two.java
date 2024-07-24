import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
        }

        long cost = 0;
        while (pq.size() > 1) {
            int num1 = pq.remove();
            int num2 = pq.remove();
            int sum = num1 + num2;
            cost += sum;
            pq.add(sum);
        }
        System.out.println(cost);
        // 여기에 코드를 작성해주세요.
    }
}