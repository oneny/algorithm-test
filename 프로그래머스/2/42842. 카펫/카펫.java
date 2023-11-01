class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int i = 3; i < total; i++) {
            if (total % i != 0) continue;
            
            int height = 2;
            int tempBrown = brown - (i * 2);
            int tempYellow = yellow;
            
            while (tempYellow > 0) {
                tempYellow -= (i - 2);
                tempBrown -= 2;
                height++;
            }
            
            
            if (tempBrown == 0 && tempYellow == 0) {
                answer[0] = i;
                answer[1] = height;
            }
        }
        
        return answer;
    }
}