class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        int length= s.length();
        HashSet<Character> stringSet = new HashSet<>();
        while (j < length) {
            if (i > j) break;
          
            if (!stringSet.contains(s.charAt(j))) {
                stringSet.add(s.charAt(j++));
                max = Math.max(max, j - i);
                continue;
            }
          
            stringSet.remove(s.charAt(i++));
        }
      
        return max;
    }
}