import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * find 연산을 수행할 때 재귀 함수에서 나오면서
 * '탐색한 모든 노드의 대표 노드값을 이번연산에서 발견한 대표 노드로 변경'
 *
 * union 연산에서 선택된 노드끼리 연결하는 것이 아닌 '선택된 노드의 대표 노드끼리 연결'
 */
public class Main {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int question = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (question == 0) { // union
        union(a, b);
      } else { // find
        boolean result = checkSame(a, b);

        if (result) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }

  private static void union(int a, int b) {
    // 대표노드를 찾아서 연결
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a; // 두 개 연결
    }
  }

  private static int find(int a) {
    if (a == parent[a]) { // 대표노드
      return a;
    }

    // a의 대표 노드를 업데이트
    parent[a] = find(parent[a]);
    return parent[a];
  }

  private static boolean checkSame(int a, int b) {
    a = find(a);
    b = find(b);

    return a == b;
  }
}
