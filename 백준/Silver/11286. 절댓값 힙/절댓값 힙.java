import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> myQueue = new PriorityQueue<>(((o1, o2) -> {
      int firstAbs = Math.abs(o1);
      int secondAbs = Math.abs(o2);

      // 절대값이 같은 경우 음수 우선
      if (firstAbs == secondAbs) {
        return o1 > o2 ? 1 : -1;
      }

      return firstAbs - secondAbs; // 절대값이 작은 데이터 우선
    }));

    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        if (myQueue.isEmpty()) {
          System.out.println("0");
        } else {
          System.out.println(myQueue.poll());
        }
      } else {
        myQueue.add(input);
      }
    }
  }
}
