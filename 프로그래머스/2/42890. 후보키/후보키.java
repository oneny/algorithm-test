import java.util.*;

class Solution {
    
    List<String> candidateKeys = new ArrayList<>();
    String[][] relations;
    
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        relations = relation;
        
        for (int i = 1; i <= columnCount; i++) {
            boolean[] visited = new boolean[columnCount];
            dfs(0, 0, i, visited);
        }
        
        return candidateKeys.size();
    }
    
    private void dfs(int idx, int depth, int max, boolean[] visited) {
        if (depth == max) {
            String cols = "";
            for (int i = 0 ; i < visited.length; i++) {
                if (visited[i]) {
                    cols += i;
                }
            }
            
            if (findIsPossible(cols, visited)) {
                candidateKeys.add(cols);
            }
            
            return;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(idx, depth + 1, max, visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean findIsPossible(String cols, boolean[] visited) {
        // 최소성 확인
        for (String candidateKey : candidateKeys) {
            boolean flag = true;
        
            for (int i = 0; i < candidateKey.length(); i++) {
                if (!cols.contains(candidateKey.charAt(i) + "")) {
                    flag = false;
                }
            }
            
            if (flag) { // 모두 포함되어 있으면
                return false;
            }
        }
        
        HashSet<String> values = new HashSet<>();
        int[] colName = new int[cols.length()];
        int idx = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])  {
                colName[idx++] = i;
            }
        }
        
        String value = "";
        for (int i = 0; i < relations.length; i++) {
            value = "";
            for (int j = 0; j < colName.length; j++) {
                value += relations[i][colName[j]];
            }
            
            if (values.contains(value)) {
                return false;
            } else {
                values.add(value);
            }
        }
        
        return true;
    }
}