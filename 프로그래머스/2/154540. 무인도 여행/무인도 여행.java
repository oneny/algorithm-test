import java.util.*;

class Solution {
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visited;
    char[][] map;
    List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        
        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[row].length(); col++) {
                map[row][col] = maps[row].charAt(col);
            }
        }
        
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (!visited[row][col] && map[row][col] != 'X') {
                    answer.add(dfs(row, col));
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.size() == 0 ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dfs(int row, int col) {
        int count = 0;
        visited[row][col] = true;
        count += map[row][col] - '0';
        map[row][col] = 'X';
        
        for (int i = 0; i < 4; i ++) {
            int dRow = row + dy[i];
            int dCol = col + dx[i];
            
            if (dRow >= 0 && dCol >= 0 && dRow < map.length && dCol < map[0].length && map[dRow][dCol] != 'X' && !visited[dRow][dCol]) {
                count += dfs(dRow, dCol);
            }
        }
        
        return count;
    }
}