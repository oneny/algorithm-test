class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        
        int length = num.length();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            
            // k > 0이면서 stack.peek()의 값이 더 크면 작은 값으로 바꿔주기
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
        }
        
        System.out.println(stack);
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        while (!stack.isEmpty()) { // StringBuilder로 변환
            result.insert(0, stack.pop());
        }
        
        while (result.length() > 1 && result.charAt(0) == '0') { // 앞문자가 0인 것들 제거
            result.deleteCharAt(0);
        }
        
        return result.toString(); 
    }
}