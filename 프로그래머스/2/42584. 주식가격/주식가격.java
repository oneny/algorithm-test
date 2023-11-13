import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Stack<Stock> stack = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().value > prices[i]) {
                    Stock stock = stack.pop();
                    answer[stock.second] = i - stock.second;
                } else {
                    break;
                }
            }
            
            stack.push(new Stock(i, prices[i]));
        }
        
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.second] = length - stock.second - 1;
        }
        
        return answer;
    }
    
    static class Stock {
        int second;
        int value;
        
        public Stock(int second, int value) {
            this.second = second;
            this.value = value;
        }
    }
}