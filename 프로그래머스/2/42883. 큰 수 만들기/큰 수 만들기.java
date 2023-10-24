import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        int length = number.length();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
        
            stack.push(number.charAt(i));
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}