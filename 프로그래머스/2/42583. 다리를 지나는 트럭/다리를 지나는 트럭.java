import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
       if (truckWeights.length == 1) return bridgeLength + 1;
        
        int result = 0;
        int currentWeight = 0;
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;

        while (index < truckWeights.length) {
            result++;
            
            if (!queue.isEmpty()) {
                if (queue.size() == bridgeLength) {
                    currentWeight -= queue.poll();
                }
                
                if (currentWeight + truckWeights[index] <= weight) {
                    currentWeight += truckWeights[index];
                    queue.add(truckWeights[index]);
                    index++;
                } else {
                    queue.add(0);
                }
            } else {
                currentWeight += truckWeights[index];
                queue.add(truckWeights[index]);
                index++;
            }
        }

        return result + bridgeLength;
    }
}