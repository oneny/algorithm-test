import java.util.*;

class Solution {
    List<List<Point>> t = new ArrayList<>(); // 테이블의 블록 좌표들 정보
    List<List<Point>> g = new ArrayList<>(); // 게임테이블의 블록 좌표들 정보
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] gameBoard, int[][] table) {
        int answer = 0;
        int len = gameBoard.length;
        
        // game_board 0, 1 바꿔주기
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (gameBoard[i][j] == 1) {
                    gameBoard[i][j] = 0;
                } else {
                    gameBoard[i][j] = 1;
                }
            }
        }
        
        boolean[][] visitedTable = new boolean[len][len];
        boolean[][] visitedGame = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // table에서 블록 추출
                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, table, visitedTable, t);
                }
                
                // gameBoard에서 빈공간 추출
                if (gameBoard[i][j] == 1 && !visitedGame[i][j]) {
                    bfs(i, j, gameBoard, visitedGame, g);
                }
            }
        }
        
        // table의 블로과 board 빈 공간의 블록을 회전하면서 비교하기
        answer = compareBlock(t, g, answer);
        
        return answer;
    }
    
    public int compareBlock(List<List<Point>> table, List<List<Point>> gameTable, int answer) {
        
        boolean[] visited = new boolean[gameTable.size()];
        
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < gameTable.size(); j++) {
                // 이미 맞춘 테이블의 블록이거나 사이즈가 다르면
                if (visited[j] || table.get(i).size() != gameTable.get(j).size()) {
                    continue;
                }
                
                if (isRotate(table.get(i), gameTable.get(j))) {
                    visited[j] = true; // 블록으로 채워짐
                    answer += gameTable.get(j).size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isRotate(List<Point> table, List<Point> gameTable) {
        // 오름차순 정렬
        Collections.sort(gameTable);
        
        // 90도씩 회전시켜보기. 0, 90, 180, 270
        for (int i = 0; i < 4; i++) {
            Collections.sort(table);
            
            int currentX = table.get(0).x;
            int currentY = table.get(0).y;
            
            // 회전하면서 좌표가 바뀌기 때문에, 다시 (0, 0) 기준으로 세팅
            for (int j = 0; j < table.size(); j++) {
                table.get(j).x -= currentX;
                table.get(j).y -= currentY;
            }
            
            boolean check = true;
            for (int j = 0; j < gameTable.size(); j++) {
                if (gameTable.get(j).x != table.get(j).x || gameTable.get(j).y != table.get(j).y) {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                return true;
            } else {
                // 90도 회전시키기 x, y -> y, -x
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        
        return false;
    }
    
    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list) {
        visited[x][y] = true;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        
        List<Point> subList = new ArrayList<>();
        subList.add(new Point(0, 0)); // (0, 0) 기준으로 넣어줌
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                    continue;
                }
                
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    subList.add(new Point(nx - x, ny - y)); // (0, 0) 기준으로 넣기 때문에
                }
            }
        }
        
        list.add(subList); // (0, 0) 기준으로 게임의 빈 블록이나 테이블의 블록들 좌표 입력
    }
    
    static class Point implements Comparable<Point> {
        int x;
        int y;
        
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Point o) {
            int res = Integer.compare(this.x, o.x);
            if (res == 0) {
                res = Integer.compare(this.y, o.y);
            }
            
            return res;
        }
    }
}