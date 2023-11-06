import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        
        Arrays.sort(people);
        
        while (start < end) {
            int min = people[start];
            int max = people[end];
            
            if (min + max == limit) {
                start++;
                end--;
                answer++;
            } else if (min + max > limit) {
                end--;
                answer++;
            } else {
                start++;
                end--;
                answer++;
            }
        }
        
        if (start == end) answer++;
        
        
        return answer;
    }
}