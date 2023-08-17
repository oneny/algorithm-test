import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  // 하, 우, 상, 좌
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static boolean[][] visited;
  static int[][] A;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();

      for (int j = 0; j < M; j++) {
        A[i][j] = str.charAt(j) - '0';
      }
    }

    bfs(0, 0);
    System.out.println(A[N - 1][M - 1]);
  }

  public static void bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {i, j});
    visited[i][j] = true;

    while (!queue.isEmpty()) { // 더 이상 탐색할 것이 없을 때까지
      int[] position = queue.poll();

      for (int k = 0; k < 4; k++) { // 상하좌우 탐색
        int x = position[0] + dx[k];
        int y = position[1] + dy[k];

        if (x >= 0 && y >= 0 && x < N && y < M) { // 유효한 좌표인지
          if (A[x][y] != 0 && !visited[x][y]) { // 이동할 수 있는 칸이면서 방문하지 않은 노드인지
            visited[x][y] = true;
            A[x][y] = A[position[0]][position[1]] + 1; // 뎁스
            queue.add(new int[] {x, y});
          }
        }
      }
    }
  }
}