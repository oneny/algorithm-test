import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        
        for (int num : scoville) {
            queue.add(num);
        }
        
        while (queue.peek() < K && queue.size() > 1) {
            count++;
            int first = queue.poll();
            int second = queue.poll();
            queue.add(first + second * 2);
        }
        
        
        return queue.size() == 1 && queue.peek() < K ? -1 : count;
    }
}