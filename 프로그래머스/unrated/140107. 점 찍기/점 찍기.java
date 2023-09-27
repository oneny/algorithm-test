class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int y = 0; y <= d; y += k) {
            long x = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(y, 2)) / k;
                
            answer += x + 1;
        }
        
        return answer;
    }
    
    public double calculateDistance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}