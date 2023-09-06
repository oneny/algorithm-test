import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Node>[] graph;
  static int N, M, K;
  static int INF = Integer.MAX_VALUE;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    graph = new ArrayList[N + 1];
    dist = new int[N + 1];

    Arrays.fill(dist, INF);

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 초기화
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph[start].add(new Node(end, weight));
    }

    StringBuilder sb = new StringBuilder();
    dijkstra(K);

    // 출력
    for (int i = 1; i <= N; i++) {
      if (dist[i] == INF) sb.append("INF\n");
      else sb.append(dist[i] + "\n");
    }

    bw.write(sb.toString());
    bw.close();
    br.close();
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    boolean[] visited = new boolean[N + 1];

    // 시작 노드는
    queue.add(new Node(start, 0));
    dist[start] = 0;

    while (!queue.isEmpty()) {
      Node curNode = queue.poll();
      int cur = curNode.end;

      if (visited[cur]) { // 이미 방문한 곳이면 넘어가기
        continue;
      }
      visited[cur] = true;

      for (Node node : graph[cur]) {
        if (dist[node.end] > dist[cur] + node.weight) { // 더 작은 거리가 있다면
          dist[node.end] = dist[cur] + node.weight;
          queue.add(new Node(node.end, dist[node.end]));
        }
      }
    }
  }

  static class Node implements Comparable<Node> {

    int end;
    int weight;

    public Node(int end, int weight) {
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return weight - o.weight;
    }
  }
}