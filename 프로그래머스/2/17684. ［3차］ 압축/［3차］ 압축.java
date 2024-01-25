import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        int mapSize = 26;
        
        // 초기화
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(Character.toString(c), c - 'A' + 1);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            int index = 0;
            String word = "";
            
            for (int j = i + 1; j <= msg.length(); j++) {
                word = msg.substring(i, j);
                
                if (dictionary.containsKey(word)) {
                    index = dictionary.get(word);
                    
                    if (j == msg.length()) {
                        i = j;
                    }
                    continue;
                } else {
                    i = j - 2;
                    break;
                }
            }
            
            dictionary.put(word, ++mapSize);
            results.add(index);
        }
        
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}