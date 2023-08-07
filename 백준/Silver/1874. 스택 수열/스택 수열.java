import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    Stack<Integer> stack = new Stack<>();
    Queue<String> queue = new LinkedList<>();
    int start = 1;
    boolean disabled = false;

    for (int i = 1; i <= N; i++) { // start: 6, num: 4, stack.peek(): 2,
      int num = scanner.nextInt();
      boolean nextStep = true;

      while (nextStep) {
        if (num < start && num > stack.peek()) {
          System.out.println("NO");
          disabled = true;
          break;
        }

        if (stack.isEmpty() || stack.peek() < num) {
          queue.add("+");
          stack.add(start);
          start++;
          continue;
        }

        if (stack.peek() >= num) {
          queue.add("-");
          stack.pop();
          break;
        }

        nextStep = false;
      }

      if (disabled) break;
    }

    if (disabled) return;

    for (String s : queue) {
      System.out.println(s);
    }
  }
}
