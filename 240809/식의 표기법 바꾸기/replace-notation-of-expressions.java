import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        LinkedList<String> operand = new LinkedList();
        LinkedList<String> operator = new LinkedList();

        for (char c: arr) {
            if (c == '(' || c == ')') continue;
            if (c >= 'A' && c <= 'Z') {
                operand.addLast(String.valueOf(c));
            } else {
                operator.addFirst(String.valueOf(c));
            }
        }
        System.out.println(String.join("", operand) + String.join("", operator));
    }
}