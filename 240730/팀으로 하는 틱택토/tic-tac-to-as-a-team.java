import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[3][];
        for (int i=0;i<3;i++) {
            board[i] = br.readLine().toCharArray();
        }
        int one = 0;
        int two = 0;
        // 가로
        for (char[] row: board) {
            HashSet<Character> set = new HashSet<>();
            for (char c: row) {
                set.add(c);
            }
            if (set.size() == 1) {
                one++;
            } else if (set.size() == 2) {
                two++;
            }
        }
        // 새로
        for (int j=0;j<3;j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i=0;i<3;i++) {
                set.add(board[i][j]);
            }
            if (set.size() == 1) {
                one++;
            } else if (set.size() == 2) {
                two++;
            }
        }
        // 대각선
        int i=0;
        int j=0;
        HashSet<Character> set = new HashSet<>();
        for (int k=0;k<3;k++) {
            set.add(board[i+k][j+k]);
        }
        if (set.size() == 1) {
            one++;
        } else if (set.size() == 2) {
            two++;
        }

        i=0;
        j=2;
        set = new HashSet<>();
        for (int k=0;k<3;k++) {
            set.add(board[i+k][j-k]);
        }
        if (set.size() == 1) {
            one++;
        } else if (set.size() == 2) {
            two++;
        }

        System.out.println(one);
        System.out.println(two);
        // 여기에 코드를 작성해주세요.
    }
}