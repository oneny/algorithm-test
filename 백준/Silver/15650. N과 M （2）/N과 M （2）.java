import java.util.Scanner;

public class Main {

  private static int[] arr;
  private static int N, M;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[M]; // M개가 차면 출력
    dfs(1, 0);
  }

  private static void dfs(int at, int depth) {
    if (M == depth) { // base case
      for (int num : arr) {
        System.out.print(num + " ");
      }
      System.out.println();
      return;
    }

    for (int i = at; i <= N; i++) {
      arr[depth] = i;

      dfs(i + 1, depth + 1);
    }
  }
}