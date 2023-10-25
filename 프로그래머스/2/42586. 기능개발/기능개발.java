import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int releaseTime = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && releaseTime >= queue.peek()) {
                queue.poll();
                count++;
            }
            
            result.add(count);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}