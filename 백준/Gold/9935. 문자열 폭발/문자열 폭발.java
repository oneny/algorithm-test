import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);

            if (stack.size() >= input.length()) {
                boolean isSame = true;

                for (int i = 0; i < input.length(); i++) {
                    if (!stack.get(stack.size() - i - 1).equals(input.charAt(input.length() - i - 1))) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int i = 0; i < input.length(); i++) {
                        stack.pop();
                    }
                }
            }

        }

        for (Character c : stack) {
            sb.append(c);
        }

        if (sb.toString().isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(sb);
    }
}
