import java.util.*;
import java.io.*;

public class Main {
    static String FORMAT = " must be milked beside ";
    static String[] names;
    static HashMap<String, Boolean> visited = new HashMap<>();
    static HashMap<String, ArrayList<String>> beside = new HashMap<>();
    static ArrayList<String> line = new ArrayList<>();
    static boolean done = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        names = new String[]{"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
        Arrays.sort(names, (o1, o2) -> o1.compareTo(o2));
        for (String name: names) {
            visited.put(name, false);
            beside.put(name, new ArrayList());
        }

        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            String[] splits = br.readLine().split(FORMAT);
            String name1 = splits[0];
            String name2 = splits[1];
            beside.get(name1).add(name2);
            beside.get(name2).add(name1);
        }
        dfs(0);
    }

    static void dfs(int count) {
        if (done) return;
        if (count == 8) {
            if (isCorrect()) {
                for (String name: line) {
                    System.out.println(name);
                }
                done = true;
            }
            return;
        }
        for (String name: names) {
            if (!visited.get(name)) {
                line.add(name);
                visited.put(name, true);
                dfs(count+1);
                line.remove(count);
                visited.put(name, false);
            }
        }
    }

    static boolean isCorrect() {
        for (int i=0;i<8;i++) {
            String me = line.get(i);
            String left = null;
            String right = null;
            if (i > 0) left = line.get(i-1);
            if (i < 7) right = line.get(i+1);
            
            for (String name: beside.get(me)) {
                if (!name.equals(left) && !name.equals(right)) return false;
            }

        }
        return true;
    }
}