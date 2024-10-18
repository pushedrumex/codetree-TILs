import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<String> word;
    static String[] remove;

    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = new LinkedList(Arrays.asList(br.readLine().split("")));
        remove = br.readLine().split("");

        M = remove.length;

        while (true) {
            int idx = find();
            if (idx == -1) break;
            for (int i=0;i<M;i++) {
                word.remove(idx);
            }
        }

        System.out.println(String.join("", word));
    }

    static int find() {
        int result = -1;
        for (int i=0;i<=word.size()-M;i++) {
            if (isSame(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    static boolean isSame(int i) {
        for (int j=0;j<M;j++) {
            if (!word.get(i++).equals(remove[j])) {
                return false;
            }
        }
        return true;
    }
}