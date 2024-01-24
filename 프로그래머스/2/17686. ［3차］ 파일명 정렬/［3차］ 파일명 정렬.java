import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = separateFile(o1);
            String[] file2 = separateFile(o2);
            
            int result = file1[0].compareTo(file2[0]);
            
            if (result == 0) {
                return toNumber(file1[1]) - toNumber(file2[1]);
            }
            
            return result;
        });
        
        
        return files;
    }
    
    private String[] separateFile(String file) {
        file = file.toLowerCase(); // 대소문자 구분 X
        
        String[] splitString = file.split("[0-9]");
        String head = splitString[0];
        String numberTail = file.substring(head.length());
        
        return new String[]{head, numberTail};
    }
    
    private int toNumber(String numberTail) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : numberTail.toCharArray()) {
            if (Character.isDigit(c) && sb.length() <= 5) {
                sb.append(c);
            } else {
                return Integer.parseInt(sb.toString());
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}