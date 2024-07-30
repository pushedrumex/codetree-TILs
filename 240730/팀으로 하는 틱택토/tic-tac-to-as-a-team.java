import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[3][3];
        for (int i=0;i<3;i++) {
            board[i] = br.readLine().split("");
        }
        int one = 0;
        int two = 0;

        HashSet<String> visited = new HashSet<>();
        // 가로
        for (String[] row: board) {
            HashSet<String> set = new HashSet<>();
            for (String c: row) {
                set.add(c);
            }
            if (set.size() == 1 && !visited.contains(String.join("", set))) {
                visited.add(String.join("", set));
                one++;
            } else if (set.size() == 2 && !visited.contains(String.join("", set))) {
                visited.add(String.join("", set));
                two++;
            }
        }
        // 새로
        for (int j=0;j<3;j++) {
            HashSet<String> set = new HashSet<>();
            for (int i=0;i<3;i++) {
                set.add(board[i][j]);
            }
            if (set.size() == 1 && !visited.contains(String.join("", set))) {
                visited.add(String.join("", set));
                one++;
            } else if (set.size() == 2 && !visited.contains(String.join("", set))) {
                visited.add(String.join("", set));
                two++;
            }
        }
        // 대각선
        int i=0;
        int j=0;
        HashSet<String> set = new HashSet<>();
        for (int k=0;k<3;k++) {
            set.add(board[i+k][j+k]);
        }
        if (set.size() == 1 && !visited.contains(String.join("", set))) {
            visited.add(String.join("", set));
            one++;
        } else if (set.size() == 2 && !visited.contains(String.join("", set))) {
            visited.add(String.join("", set));
            two++;
        }

        i=0;
        j=2;
        set = new HashSet<>();
        for (int k=0;k<3;k++) {
            set.add(board[i+k][j-k]);
        }
        if (set.size() == 1 && !visited.contains(String.join("", set))) {
            visited.add(String.join("", set));
            one++;
        } else if (set.size() == 2 && !visited.contains(String.join("", set))) {
            visited.add(String.join("", set));
            two++;
        }

        System.out.println(one);
        System.out.println(two);
    }
}