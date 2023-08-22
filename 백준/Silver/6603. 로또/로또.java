import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static int k;
  static LinkedList<Integer> list;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());

      k = Integer.parseInt(st.nextToken());
      arr = new int[k];

      if (k == 0) {
        break;
      }

      for (int i = 0; i < k; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i <= k - 6; i++) {
        list = new LinkedList<>();
        dfs(arr[i], i + 1);
      }

      System.out.println();
    }
  }

  private static void dfs(int num, int idx) {
    list.add(num);

    if (list.size() == 6) {
      for (Integer lottoNum : list) {
        System.out.print(lottoNum + " ");
      }
      System.out.println();
      return;
    }

    for (int i = idx; i < k; i++) {
      dfs(arr[i], i + 1);
      list.removeLast();
    }
  }
}