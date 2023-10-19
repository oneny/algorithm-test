import java.util.*;

class Solution {

    ArrayList<String> list = new ArrayList<>();
    boolean[] usedTickets;

    public String[] solution(String[][] tickets) {
        usedTickets = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);

        return list.get(0).split(" ");
    }
    
    private void dfs(int depth, String current, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!usedTickets[i] && current.equals(tickets[i][0])) {
                usedTickets[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                usedTickets[i] = false;
            }
        }
    }
}