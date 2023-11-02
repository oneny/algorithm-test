class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int width = 3; width < brown; width++) {
            int height = total / width;
            
            if (total % width == 0 && (width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
            }
        }
        
        return answer;
    }
}