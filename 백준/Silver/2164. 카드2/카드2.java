import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    for (int i = 1; i <= num; i++) {
      deque.addLast(i);
    }

    int count = 1;
    while (true) {
      if (deque.size() == 1) {
        break;
      }

      if (count % 2 == 1) {
        deque.removeFirst();
        count++;
      }

      if (count % 2 == 0) {
        Integer removeFirst = deque.removeFirst();
        deque.addLast(removeFirst);
        count--;
      }
    }

    System.out.println(deque.removeLast());
  }
}