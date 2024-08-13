import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        char[] arr3 = br.readLine().toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;

        int[][][] dp = new int[n1+1][n2+1][n3+1];
        for (int i=1;i<=n1;i++) {
            for (int j=1;j<=n2;j++) {
                for (int k=1;k<=n3;k++) {
                    if (arr1[i-1] == arr2[j-1] && arr2[j-1] == arr3[k-1]) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i][j-1][k], dp[i][j][k-1]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                    }
                }
            }
        }
        System.out.println(dp[n1][n2][n3]);
    }
}