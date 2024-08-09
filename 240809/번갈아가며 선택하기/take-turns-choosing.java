import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int n;
    static int m;
    static String[] A;
    static String[] B;
    static String[] C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = br.readLine().split("");
        A = br.readLine().split("");
        B = br.readLine().split("");
        n = C.length;
        m = A.length;
        for (int i=0;i<m;i++) {
            dfs(0, i, 'A');
            dfs(0, i, 'B'); 
        }
        System.out.println(answer);
    }

    static void dfs(int cIdx, int idx, char turn) {
        if (cIdx == n) {
            answer++;
            return;
        }
        String[] s = turn == 'A' ? A : B;
        
        while (idx < m && !s[idx].equals(C[cIdx])) {
            idx++;
        }
        if (idx == m) return;
        dfs(cIdx+1, idx+1, turn == 'A' ? 'B' : 'A');
    }
}