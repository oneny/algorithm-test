import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        for (String str : arr) {
            Stack<Character> stack = new Stack<>();
            boolean pass = true;

            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.add(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    pass = false;
                    System.out.println("NO");
                    break;
                }

                stack.pop();
            }

            if (!stack.isEmpty()) {
                System.out.println("NO");
                continue;
            }

            if (pass) {
                System.out.println("YES");
            }
        }
    }
}
