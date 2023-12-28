class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            
            answer[start - 1] += seats;
            if (end < n) {
                answer[end] -= seats;
            }
        }
        
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += answer[i];
            answer[i] = currSum;
        }
        
        return answer;
    }
}