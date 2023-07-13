class Solution {
    
    int ans;
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ans = baseCosts[0];
        
        for (int baseCost : baseCosts) { // baseCosts를 돌면서 target에 근접한 합계 계산
            dfs(baseCost, 0, target, toppingCosts);
        }
        
        return ans;
    }
    
    private void dfs(int currentCost, int i, int target, int[] toppingCosts) {
        // 두 차이 절대값이 같으면 낮은 currentCost를 선택
        if (Math.abs(target - currentCost) < Math.abs(target - ans) || (Math.abs(target - currentCost) == Math.abs(target - ans) && currentCost <= target)) {
            ans = currentCost;
        }
        

        if (i == toppingCosts.length || currentCost >= target) {
            return;
        }

        dfs(currentCost, i + 1, target, toppingCosts);
        dfs(currentCost + toppingCosts[i], i + 1, target, toppingCosts);
        dfs(currentCost + toppingCosts[i] * 2, i + 1, target, toppingCosts);
    }
}