import java.util.*;

class Solution {
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        bfs(maps);
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
    
    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = position[0] + dx[i];
                int y = position[1] + dy[i];
                
                if (x >= 0 && y >= 0 && x < maps[0].length && y < maps.length) {
                    if (!visited[y][x] && maps[y][x] != 0) {
                        visited[y][x] = true;
                        maps[y][x] = maps[position[1]][position[0]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}