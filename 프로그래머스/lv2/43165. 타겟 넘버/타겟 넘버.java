class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(target, 0, 0, numbers);
        
        return answer;
    }
    
    private void dfs(int target, int sum, int i, int[] numbers) {
        if (i == numbers.length) { // base case
            if (sum == target) answer++;
            
            return;
        }
        
        dfs(target, sum + numbers[i], i + 1, numbers);
        dfs(target, sum - numbers[i], i + 1, numbers);
    }
}