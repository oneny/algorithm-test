class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dy = new boolean[n + 1];
        dy[n] = true;
        
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= n && word.equals(s.substring(i, i + word.length()))) {
                    dy[i] = dy[i + word.length()];
                }
                
                if (dy[i]) break;
            }
        }
        
        return dy[0];
    }
}