import java.util.*;

class Solution {
    
    ArrayList<Integer>[] map;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            map[start].add(end);
            map[end].add(start);
        }
        
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            boolean[] visited = new boolean[n + 1];
            
            map[start].remove(Integer.valueOf(end));
            map[end].remove(Integer.valueOf(start));
            
            int count = dfs(1, visited);
            int diff = Math.abs(count - (n - count));
            
            answer = Math.min(answer, diff);
            
            map[start].add(end);
            map[end].add(start);
        }
        
        return answer;
    }
    
    private int dfs(int index, boolean[] visited) {
        visited[index] = true;
        int count = 1;
        
        for (int v : map[index]) {
            if (!visited[v]) {
                count += dfs(v, visited);
            }
        }
        
        return count;
    }
}