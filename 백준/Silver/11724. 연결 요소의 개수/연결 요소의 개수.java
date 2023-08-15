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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    A = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      A[s].add(e); // 양쪽 방향에 추가해야함
      A[e].add(s); // 양쪽 방향에 추가해야함
    }

    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }

    System.out.println(count);
  }

  private static void dfs(int i) {
    if (visited[i]) { // 방문 노드인 경우
      return;
    }

    visited[i] = true;
    // 현재 노드의 연결 노드 중 방문하지 않은 노드로 dfs 실행
    for (int j : A[i]) {
      if (!visited[j]) {
        dfs(j);
      }
    }
  }
}