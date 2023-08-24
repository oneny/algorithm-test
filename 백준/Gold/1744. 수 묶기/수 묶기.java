import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int result = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr); // 1 1 2 2 3

    int end = N - 1;
    int start = 0;

    while (end > 0) {
      if (arr[end] <= 1 || arr[end - 1] <= 1) {
        break;
      }

      result += (arr[end] * arr[end - 1]);
      end -= 2;
    }

    while (end >= 0 && start <= end) {
      if (start + 1 <= end && arr[start] < 0 && arr[start + 1] < 0) {
        result += (arr[start] * arr[start + 1]);
        start += 2;
        continue;
      }

      if (arr[end] == 0) {
        result += (arr[end--] * arr[start++]);
        continue;
      }

      result += arr[end];
      end--;
    }

    System.out.println(result);
  }
}