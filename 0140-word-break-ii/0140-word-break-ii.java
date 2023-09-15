class Solution {
    
    StringBuilder sb = new StringBuilder();
    List<String> possibleSentences = new ArrayList<>();
    LinkedList<String> words = new LinkedList<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(0, s, wordDict);
        
        return possibleSentences;
    }
    
    public void dfs(int index, String s, List<String> wordDict) {
        if (s.equals(sb.toString())) {
            StringBuilder successSb = new StringBuilder();
            
            for (int k = 0; k < words.size(); k++) {
                successSb.append(words.get(k) + " ");
            }
            
            successSb.setLength(successSb.length() - 1);
            
            possibleSentences.add(successSb.toString());
            
            return;
        }
        
        for (int k = 0; k < wordDict.size(); k++) {
            int findIndex = s.indexOf(wordDict.get(k), index);
            
            if (findIndex != -1) {
                sb.append(wordDict.get(k));
                words.add(wordDict.get(k));
                dfs(findIndex + wordDict.get(k).length(), s, wordDict);
                sb.setLength(sb.length() - wordDict.get(k).length());
                words.removeLast();
            }
        }
    }
}