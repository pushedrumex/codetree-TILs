import java.util.*;
import java.io.*;

public class Main {
    static Comparator<Problem> maxComparator = (o1, o2) -> {
        if (o1.l != o2.l) return o2.l - o1.l;
        return o2.p-o1.p;
    };

    static Comparator<Problem> minComparator = (o1, o2) -> {
        if (o1.l != o2.l) return o1.l - o2.l;
        return o1.p-o2.p;
    };

    static PriorityQueue<Problem> totalMax = new PriorityQueue(maxComparator);
    static PriorityQueue<Problem> totalMin = new PriorityQueue(minComparator);

    static HashMap<Integer, PriorityQueue<Problem>> maxMap = new HashMap();
    static HashMap<Integer, PriorityQueue<Problem>> minMap = new HashMap();

    static HashMap<Integer, Integer> lMap = new HashMap(); // 난이도
    static HashMap<Integer, Boolean> dMap = new HashMap(); // 제거 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            addProblem(p, l, g);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("rc1")) {
                int x = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    PriorityQueue<Problem> problems = maxMap.get(g);
                    deleteInvalid(problems);
                    if (problems.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(problems.peek().p);
                    }
                } else if (x == -1) {
                    PriorityQueue<Problem> problems = minMap.get(g);
                    deleteInvalid(problems);
                    if (problems.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(problems.peek().p);
                    }  
                }

            } else if (cmd.equals("rc2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    deleteInvalid(totalMax);
                    if (totalMax.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(totalMax.peek().p);
                    }
                } else if (x == -1) {
                    deleteInvalid(totalMin);
                    if (totalMin.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(totalMin.peek().p);
                    }  
                }

            } else if (cmd.equals("rc3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                if (x == 1) {
                } else if (x == -1) {
                }

            } else if (cmd.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                addProblem(p, l, g);
            } else if (cmd.equals("sv")) {
                int p = Integer.parseInt(st.nextToken());
                dMap.put(p, true);
            }
        }
    }

    static void deleteInvalid(PriorityQueue<Problem> problems) {
        if (problems.isEmpty()) return;
        while (!problems.isEmpty()) {
            Problem problem = problems.peek();
            if (dMap.get(problem.p) == false || lMap.get(problem.p) == problem.l) {
                break;
            }
            problems.remove();
        }
    }

    static void addProblem(int p, int l, int g) {
        Problem problem = new Problem(p, l);

        totalMax.add(problem);
        totalMin.add(problem);

        maxMap.getOrDefault(g, new PriorityQueue(maxComparator)).add(problem);
        minMap.getOrDefault(g, new PriorityQueue(minComparator)).add(problem);

        lMap.put(p, l);
        dMap.put(p, false);
    }

    static class Problem {
        int p;
        int l;
        Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}