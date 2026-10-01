import java.util.Stack;
import java.util.Scanner;

public class w3_tailop_25023542 {
    public static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // hàm chuyển trung tố sang hậu tố
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder(); // lưu kết quả
        Stack<Character> stack = new Stack<>();     // stack chứa toán tử và dấu ngoặc

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') {
                continue;
            }
            // nếu là toán hạng thêm thẳng vào kết quả
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } 

            else if (c == '(') {
                stack.push(c);
            } 

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // nếu là toán tử (+, -, *, /)
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // rút các toán tử còn lại trong ngăn xếp đưa vào kết quả
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chuyển biểu thức trung tố sang hậu tố");
        System.out.print("Nhập biểu thức: ");        
        String infixExpression = scanner.nextLine();
        String postfixExpression = infixToPostfix(infixExpression);     
        System.out.println("Biểu thức hậu tố (Ba Lan ngược): " + postfixExpression);
        scanner.close();
    }
}