class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int index = i;
            
            while (index != s.length()) {
                char c = s.charAt(index);
                
                if (sb.toString().contains(Character.toString(c))) {
                    break;
                }
                
                sb.append(c);
                index++;
            }
            
            if (sb.length() > max) {
                max = sb.length();
            }
        }
        
        return max;
    }
}