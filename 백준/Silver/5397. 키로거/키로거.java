import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  private static final char BACKSPACE = '-';
  private static final char LEFT_ARROW = '<';
  private static final char RIGHT_ARROW = '>';

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      Stack<String> left = new Stack<>();
      Stack<String> right = new Stack<>();
      StringBuilder sb = new StringBuilder();
      String input = sc.next();

      for (char c : input.toCharArray()) {
        if (c == BACKSPACE) {
          if (!left.isEmpty()) {
            left.pop();
          }
          continue;
        }

        if (c == LEFT_ARROW) {
          if (!left.isEmpty()) {
            right.add(left.pop());
          }
          continue;
        }

        if (c == RIGHT_ARROW) {
          if (!right.isEmpty()) {
            left.add(right.pop());
          }
          continue;
        }

        left.add(String.valueOf(c));
      }

      while (!left.isEmpty()) {
        right.add(left.pop());
      }

      while (!right.isEmpty()) {
        sb.append(right.pop());
      }

      System.out.println(sb);
    }
  }
}