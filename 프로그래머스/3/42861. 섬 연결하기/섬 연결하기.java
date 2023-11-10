import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, (int[] o1, int[] o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < costs.length; i++) {
            if (findParent(costs[i][0]) != findParent(costs[i][1])) {
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        
        return findParent(parent[node]);
    }
    
    private void union(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        
        if (parent1 < parent2) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
    }
}