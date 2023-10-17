import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] vertex : edge) {
            int start = vertex[0];
            int end =  vertex[1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        return bfs(n);
    }
    
    public int bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        
        queue.add(new int[] {1, 0}); // {value, depth}
        visited[1] = true;
        int maxDepth = 0;
        
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int value = arr[0];
            int depth = arr[1];
            
            if (maxDepth == depth) {
                answer++;
            } else if (maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for (int i = 0; i < graph[value].size(); i++) {
                int adjacentValue = graph[value].get(i);

                if (!visited[adjacentValue]) {
                    queue.add(new int[]{adjacentValue, depth + 1});
                    visited[adjacentValue] = true;
                }
            }
        }
        
        return answer;
    }
}