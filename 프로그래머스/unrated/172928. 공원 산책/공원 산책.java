import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] chars = new char[park.length][park[0].length()];
        Position position = new Position();
        
        for (int y = 0; y < park.length; y++) {
            chars[y] = park[y].toCharArray();
            
            if (park[y].contains("S")) {
                position.x = park[y].indexOf("S");
                position.y = y;
            }
        }
        
        for (String route : routes) {
            String[] strs = route.split(" ");
            String direction = strs[0];
            int count = Integer.parseInt(strs[1]);
            
            int tempX = position.x;
            int tempY = position.y;
            
            for (int i = 1; i <= count; i++) {
                if (direction.equals("N")) {
                    tempY--;
                }
                if (direction.equals("S")) {
                    tempY++;
                }
                if (direction.equals("W")) {
                    tempX--;
                }
                if (direction.equals("E")) {
                    tempX++;
                }
                if (tempX >= 0 && tempY >= 0 && tempY < chars.length && tempX < chars[0].length) {
                    System.out.println(tempY + ", " + tempX);
                    if (chars[tempY][tempX] == 'X') {
                        break;
                    }
                    
                    if (i == count) { // 횟수만큼 했는데 장애물 없었으면
                        position.x = tempX;
                        position.y = tempY;
                    }
                }
            }
        }
        
        int[] answer = {position.y, position.x};
        return answer;
    }
    
    class Position {
        int x;
        int y;
    }
}