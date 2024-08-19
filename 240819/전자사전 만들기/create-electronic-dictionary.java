import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Word> words;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        for (int i=0;i<N;i++) {
            words.add(new Word(br.readLine(), i+1));
        }

        Collections.sort(words, (o1, o2) -> o1.str.compareTo(o2.str));

        for (int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String prefix = st.nextToken();
            int idx = bs(prefix);

            int result = 0;
            if (idx == -1 || idx+k-1 >= N) {
                result = -1;
            } else if (!words.get(idx+k-1).str.substring(0, prefix.length()).equals(prefix)) {
                result = -1;
            } else {
                result = words.get(idx+k-1).idx;
            }
            System.out.println(result);
        }
    }

    static int bs(String prefix) {
        int result = -1;
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 같거나 큰 단어
            if (words.get(mid).str.compareTo(prefix) >= 0) {
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }

    static class Word {
        String str;
        int idx;
        Word(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }
}