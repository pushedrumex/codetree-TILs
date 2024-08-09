import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);

        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c: arr) {
            switch (c){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
                        answer += String.valueOf(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        answer += String.valueOf(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    answer += String.valueOf(c);
            }
        }
        while (!stack.isEmpty()) {
            answer += String.valueOf(stack.pop());
        }
        System.out.println(answer);
    }
}