import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int i = 0;
        while (i < n) {
            boolean flag = false;
            for (int size=2;i+size-1<n;size+=2) {
                if (isPalindrome(i, size)) {
                    i += size;
                    answer++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
    static boolean isPalindrome(int i, int size) {
        for (int j=i;j<i+size/2;j++) {
            if (nums[j] != nums[i+size-j+i-1]) return false;
        }
        return true;
    }
}