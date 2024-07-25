import java.util.*;
import java.io.*;

public class Main {
    static String[][] graph;
    static char c = 'A';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = 2 * n - 1;
        graph = new String[m][m];
        for (String[] row: graph) {
            Arrays.fill(row, " ");
        }

        for (int x=0;x<n;x++) {
            fill(x, m / 2, n-x);
        }

        for (String[] row: graph) {
            System.out.println(String.join(" ", row));
        }

    }

    static void fill(int x, int y, int size) {
        if (size == 1) {
            graph[x][y] = String.valueOf(c);
            return;
        }

        for (int i=0;i<size-1;i++) {
            graph[x++][y--] = String.valueOf(c);
            c++;
            if (c > 'Z') {
                c = 'A';
            }
        }
        for (int i=0;i<size-1;i++) {
            graph[x++][y++] = String.valueOf(c);
            c++;
            if (c > 'Z') {
                c = 'A';
            }
        }
        for (int i=0;i<size-1;i++) {
            graph[x--][y++] = String.valueOf(c);
            c++;
            if (c > 'Z') {
                c = 'A';
            }
        }
        for (int i=0;i<size-1;i++) {
            graph[x--][y--] = String.valueOf(c);
            c++;
            if (c > 'Z') {
                c = 'A';
            }
        }
    }
}