class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums.length <= 2) {
            return Collections.emptyList();
        }
        
        Arrays.sort(nums);
        
        int notNegativeIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                notNegativeIdx = i;
                break;
            }
        }
        
        if (notNegativeIdx == -1) {
            return Collections.emptyList();
        }
        
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i <= notNegativeIdx; i++) {
            
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
            
            if (nums[i] == 0) {
                if (nums[i] - i > 2 && nums[i + 1] == 0 && nums[i + 2] == 0) {
                    result.add(Arrays.asList(0, 0, 0));
                    
                }
                
                return new ArrayList<>(result);
            }
        }
        
        return new ArrayList<>(result);
    }
}