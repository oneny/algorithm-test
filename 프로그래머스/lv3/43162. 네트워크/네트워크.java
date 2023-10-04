import java.util.*;

class Solution {
    
    static int count = 0;
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        // 초기화
        visited = new boolean[n];
        network = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }
        
        // 연결 정보
        for (int i = 0; i < n; i++) {
                
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] == 0) {
                    continue;
                }
                
                network[i].add(j);
            }
        }
        
        // dfs
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        
        return count;
    }
    
    public void dfs(int start) {
        visited[start] = true;
        
        for (int adj : network[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}