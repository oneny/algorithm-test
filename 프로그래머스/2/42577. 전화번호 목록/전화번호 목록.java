import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new TreeSet<>();
        
        for (String phone : phoneBook) {
            set.add(phone);
        }
        
        for (String phone : phoneBook) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}