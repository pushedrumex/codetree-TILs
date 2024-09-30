import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ns = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if (d.equals("NS")) ns.add(n);
            else s.add(n);
        }

        Collections.sort(ns);
        Collections.sort(s);

        int answer = 0;
        for (int i=A;i<=B;i++) {
            int diff1 = bs(i, ns);
            int diff2 = bs(i, s);

            if (diff1 >= diff2) answer++;
        }
        System.out.println(answer);
        // 여기에 코드를 작성해주세요.
    }

    static int bs(int n, ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int diff = Math.abs(arr.get(mid)-n);
            if (diff < answer) {
                answer = diff;
                if (arr.get(mid) > n) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                break;
            }
        }
        return answer;
    }
}