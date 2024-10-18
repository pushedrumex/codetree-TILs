import java.util.*;
import java.io.*;

public class Main {
    static Present[] presents;
    static int N;
    static int B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        presents = new Present[N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int delivery = Integer.parseInt(st.nextToken());
            presents[i] = new Present(cost, delivery);
        }
        
        int answer = 0;
        // 하나씩 할인해보자
        for (int i=0;i<N;i++) {
            presents[i].cost /= 2;

            Arrays.sort(presents, (o1, o2) -> {
                double diff = (o1.cost + o1.delivery) - (o2.cost + o2.delivery);
                if (diff < 0) return -1;
                if (diff > 0) return 1;
                return 0;
            });
            answer = Math.max(answer, countMax());

            presents[i].cost *= 2;
        }

        System.out.println(answer);
    }

    static int countMax() {
        int count = 0;
        int money = B;
        for (int i=0;i<N;i++) {
            double totalCost = presents[i].cost + presents[i].delivery;
            if (money >= totalCost) {
                money -= totalCost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    static class Present {
        double cost;
        int delivery;
        Present(double cost, int delivery) {
            this.cost = cost;
            this.delivery = delivery;
        }
    }
}