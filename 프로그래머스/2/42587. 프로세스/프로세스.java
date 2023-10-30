import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int priority : priorities) {
            queue.offer(priority);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    queue.poll();
                    answer++;
                    
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        
        
        return answer;
    }
}