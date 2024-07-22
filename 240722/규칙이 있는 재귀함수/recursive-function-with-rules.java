import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        arr[0] = 2;
        recur(2);
        System.out.println(String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }
    static void recur(int t) {
        if (t > n) {
            return;
        }
        arr[t-1] = arr[t/2-1] + arr[t-1-1];
        recur(t+1);
    }
}