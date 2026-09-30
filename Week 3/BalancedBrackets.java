import java.io.*;
import java.util.*;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return "NO";
                }
                if (c == ']' && top != '[') {
                    return "NO";
                }
                if (c == '}' && top != '{') {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                System.out.println(isBalanced(s));
            }
        }
        scanner.close();
    }
}