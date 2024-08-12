import java.util.*;
import java.io.*;

public class Main {
    // 난이도 내림차순, 번호 내림차순
    static Comparator<Problem> maxComparator = (o1, o2) -> {
        if (o1.l != o2.l) return o2.l - o1.l;
        return o2.p-o1.p;
    };

    static TreeSet<Problem> totalSet = new TreeSet(maxComparator);
    static HashMap<Integer, TreeSet<Problem>> map = new HashMap();
    static HashMap<Integer, Problem> problemMap = new HashMap();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l, g);
            totalSet.add(problem);
            if (!map.containsKey(g)) {
                map.put(g, new TreeSet(maxComparator));
            }
            map.get(g).add(problem);
            problemMap.put(p, problem);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int result = -1;

            if (cmd.equals("rc1")) {
                int x = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                TreeSet<Problem> problems = map.get(g);

                if (problems != null && !problems.isEmpty()) {
                    if (x == 1) {
                        result = problems.first().p;
                    } else if (x == -1) {
                        result = problems.last().p;
                    }
                }

            } else if (cmd.equals("rc2")) {
                int x = Integer.parseInt(st.nextToken());

                if (!totalSet.isEmpty()) {
                    if (x == 1) {
                        result = totalSet.first().p;
                    } else if (x == -1) {
                        result = totalSet.last().p;
                    }
                }
            } else if (cmd.equals("rc3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    Problem problem = totalSet.floor(new Problem(Integer.MAX_VALUE, l, 0));
                    if (problem != null) {
                        result = problem.p;
                    }
                } else if (x == -1) {
                    Problem problem  = totalSet.higher(new Problem(-1, l, 0));
                    if (problem != null) {
                        result = problem.p;
                    }
                }
            } else if (cmd.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                if (problemMap.containsKey(p)) {
                    Problem problem = problemMap.get(p);
                    totalSet.remove(problem);
                    map.get(g).remove(problem);
                }
                Problem problem = new Problem(p, l, g);
                totalSet.add(problem);
                if (!map.containsKey(g)) {
                    map.put(g, new TreeSet(maxComparator));
                }
                map.get(g).add(problem);
                problemMap.put(p, problem);
                continue;
            } else if (cmd.equals("sv")) {
                int p = Integer.parseInt(st.nextToken());
                Problem problem = problemMap.get(p);
                totalSet.remove(problem);
                map.get(problem.g).remove(problem);
                continue;
            }
            System.out.println(result);
        }
    }

    static class Problem {
        int p;
        int l;
        int g;
        Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }
    }
}