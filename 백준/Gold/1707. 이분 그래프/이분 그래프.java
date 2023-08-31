import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Integer>[] A;
  static int[] check;
  static boolean[] visited;
  static boolean isEven;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCount = Integer.parseInt(br.readLine());

    // 사이클이 발생하면 이분 그래프 불가능 -> 갔던 노드를 다시 탐색했을때 같은 집합이면 이분 그래프 불가능
    for (int t = 0; t < testCount; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken()); // 노드 개수
      int E = Integer.parseInt(st.nextToken()); // 엣지 개수
      A = new ArrayList[V + 1];
      visited = new boolean[V + 1];
      check = new int[V + 1];
      isEven = true;

      for (int i = 0; i <= V; i++) {
        A[i] = new ArrayList<>();
      }

      // 엣지 입력
      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        A[start].add(end);
        A[end].add(start);
      }

      // 모든 노드 dfs 실행
      for (int i = 1; i <= V; i++) {
        if (isEven) {
          dfs(i);
        } else { // 이분 그래프가 아니면
          break;
        }
      }

      System.out.println(isEven ? "YES" : "NO");
    }
  }
  public static void dfs(int node) {
    visited[node] = true;

    for (int i : A[node]) { // 노드에 연결된 노드 탐색
      if (!visited[i]) {
        check[i] = (check[node] + 1) % 2; // node와는 다른 집합(node가 1인 경우 인접한 node는 0, node가 0이면 그 반대)
        dfs(i);
      } else {
        if (check[i] == check[node]) {
          isEven = false;
          break;
        }
      }
    }
  }
}