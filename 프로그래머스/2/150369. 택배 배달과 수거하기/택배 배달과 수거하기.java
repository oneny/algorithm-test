class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliveryCount = 0;
        int pickCount = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            deliveryCount -= deliveries[i];
            pickCount -= pickups[i];
            
            while (deliveryCount < 0 || pickCount < 0) {
                deliveryCount += cap;
                pickCount += cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}