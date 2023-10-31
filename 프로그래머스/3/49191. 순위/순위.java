import java.util.*;

class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    // j가 i를 이기고 i가 k를 이기면 j가 k를 이김
                    if (graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1) { // 이기거나 지거나 게임 횟수
                    game++;
                }
            }
            
            if (game == (n - 1)) { // 자기 자신과의 게임을 뺀 횟수
                answer++;
            }
        }

        return answer;
    }
}