class Solution {
    
    static String[] phoneNumbers = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int[] digitArr;
    List<String> answer = new LinkedList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return answer;
            
        digitArr = new int[digits.length()];
        
        for (int i = 0; i < digits.length(); i++) {
            digitArr[i] = digits.charAt(i) - 48;
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        
        return answer;
    }
    
    public void dfs(int depth, StringBuilder sb) {
        if (depth == digitArr.length) {
            answer.add(sb.toString());
            return;
        }
        
        String text = phoneNumbers[digitArr[depth]];
        
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            dfs(depth + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}