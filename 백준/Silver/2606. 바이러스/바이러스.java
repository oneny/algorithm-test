import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  private static int count = 0;
  private static boolean[] visited;
  private static ArrayList<Integer>[] A;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    visited = new boolean[N]; // 0 ~ 6번 인덱스 방문하는지 확인용
    A = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      A[s - 1].add(e - 1);
      A[e - 1].add(s - 1);
    }

    dfs(0);

    System.out.println(count - 1);
  }

  private static void dfs(int i) {
    if (visited[i]) {
      return;
    }

    visited[i] = true;
    count++;
    for (int j : A[i]) {
      if (!visited[j]) {
        dfs(j);
      }
    }
  }
}