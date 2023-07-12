import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            Top top = new Top(Integer.parseInt(st.nextToken()), i);

            while (!stack.isEmpty() && stack.peek().height < top.height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                sb.append(stack.peek().value + " ");
            } else {
                sb.append("0 ");
            }

            stack.add(top);
        }

        System.out.println(sb);
        br.close();
    }
}

class Top {

    int height;
    int value;

    public Top(int height, int value) {
        this.height = height;
        this.value = value;
    }
}
