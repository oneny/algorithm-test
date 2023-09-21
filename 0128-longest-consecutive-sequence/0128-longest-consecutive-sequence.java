class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                
                int sum = left + right + 1;
                result = Math.max(sum, result);
                
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        
        return result;
    }
}