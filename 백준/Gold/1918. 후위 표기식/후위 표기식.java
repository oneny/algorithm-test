import java.util.Scanner;
import java.util.Stack;

public class Main {

    // 우선순위 지정 함수
    private static int priority(char operator) {
        if (operator == '(') return 0;
        else if (operator == '+' || operator == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    char operator = stack.pop();
                    sb.append(operator);
                }
                stack.pop(); // '('까지 제거
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                while (!stack.isEmpty() && (priority(stack.peek()) >= priority(c))) {
                    sb.append(stack.pop());
                }
                stack.add(c);
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
