import java.util.*;
import java.io.*;

public class Main {
    static int one = 0;
    static int zero = 0;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        one = Integer.parseInt(br.readLine());
        dfs("");
        System.out.println(set.size());
    }

    static void dfs(String s) {
        if (one + zero == 0) {
            set.add(s);
            return;
        }
        if (one > 0) {
            one--;
            zero++;
            dfs(s+"b");
            one++;
            zero--;
        }
        if (zero > 0) {
            zero--;
            dfs(s+"a");
            zero++;
        }
    }
}