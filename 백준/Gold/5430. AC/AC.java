import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String p = sc.next();
            int n = sc.nextInt();
            String arrStr = sc.next();
            Deque<Integer> deque = new ArrayDeque<>();

            for (String s : arrStr.substring(1, arrStr.length() - 1).split(",")) {
                if (!s.equals("")) deque.add(Integer.parseInt(s));
            }

            System.out.println(ac(deque, p));
        }
    }

    private static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                reverse = !reverse;
            } else {
                if (deque.size() == 0) {
                    return "error";
                }

                if (reverse) {
                    deque.removeLast();
                    continue;
                }
                
                deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (deque.size() != 0) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
