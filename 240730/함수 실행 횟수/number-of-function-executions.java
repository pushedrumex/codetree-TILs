import java.util.*;
import java.io.*;

public class Main {
    static long count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        codetree(n);
        System.out.println(count % 1_000_000_007);
    }
    static int codetree(int n) {
        count++;
        if (n < 2) {
            return n;
        } else {
            return codetree(n-1) + codetree(n-2);
        }
    }
}