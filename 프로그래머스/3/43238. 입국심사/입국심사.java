import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1]; // 가장 최악의 경우(오래 걸리는 시간)
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 총 심사한 인원
            
            // mid 값으로 각 심사관들(times)이 몇 명을 심사할 수 있는지 계산
            for (int time : times) { 
                sum += mid / time;
            }
            
            if (sum >= n) { // n보다 크거나 같아야 시간 안에 심사 가능
                answer = mid;
                right = mid - 1;
            } else { // 작으면 시간 안에 심사를 못한 것
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}