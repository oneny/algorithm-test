import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 10_000;
        int length = citations.length;

        Arrays.sort(citations);

        while (answer > 0) {
            int quote = 0;
            int i = 0;

            for (i = 0; i < length; i++) {
                if (citations[i] >= answer) {
                    quote = length - i;
                    break;
                }
            }

            if (quote >= answer && i <= quote) {
                break;
            }

            answer--;
        }

        return answer;
    }
}