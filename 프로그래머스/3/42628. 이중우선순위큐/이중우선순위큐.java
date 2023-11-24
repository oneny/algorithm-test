import java.util.*;

class Solution {
    public int[] solution(String[] operations) {  
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] splits = operation.split(" ");
            String direction = splits[0];
            int number = Integer.parseInt(splits[1]);
            
            
            if (direction.equals("I")) {
                maxPq.offer(number);
                minPq.offer(number);
            } else {
                if (maxPq.isEmpty()) continue;
                
                if (number == 1) {
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
            }
        }
        
        return maxPq.isEmpty() ? new int[]{0, 0} : new int[]{maxPq.poll(), minPq.poll()};
    }
}