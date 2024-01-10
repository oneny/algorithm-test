import java.util.*;

class Solution {
    public String[] solution(String[][] plansArr) {
        Plan[] plans = new Plan[plansArr.length];
        for (int i = 0; i < plansArr.length; i++) {
            plans[i] = new Plan(plansArr[i][0], plansArr[i][1], plansArr[i][2]);
        }
        Arrays.sort(plans, (o1, o2) -> o1.start - o2.start);
        
        Stack<Plan> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        
        int currTime = -1;
        for (int i = 0; i < plans.length; i++) {
            if (stack.isEmpty()) {
                stack.push(plans[i]);
                continue;
            }
            
            Plan currPlan = stack.peek(); // 진행중인 과제
            Plan nextPlan = plans[i]; // 다음 과제
            
            // 현재 과제 시작 시간 + 작업 시간이 새로운 과제 시작 시간보다 같거나 작은 경우
            if (currPlan.getEndTime() <= nextPlan.start) {
                recursivePop(stack, nextPlan, currPlan.start, answer);
            } else {
                // 현재 작업 중단하고 작업한 시간 갱신 및 새 작업 시작
                currPlan.playTime -= (nextPlan.start - currPlan.start);
            }
                                      
            stack.push(nextPlan);
        }
        
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    private void recursivePop(Stack<Plan> stack, Plan nextPlan, int currTime, List<String> answer) {
        if (stack.isEmpty()) {
            return;
        }
        
        Plan currPlan = stack.peek(); // 진행 중인 과제
        if (currTime + currPlan.playTime <= nextPlan.start) {
            answer.add(stack.pop().name);
            recursivePop(stack, nextPlan, currTime + currPlan.playTime, answer);
        } else {
            currPlan.playTime -= (nextPlan.start - currTime);
        }
    }
    
    class Plan {
        String name;
        int start;
        int playTime;
        
        public Plan(String name, String start, String playtime) {
            String[] time = start.split(":");
            this.name = name;
            this.start = makeMinutes(time[0], time[1]);
            this.playTime = Integer.parseInt(playtime);
        }
        
        public int makeMinutes(String hours, String minutes) {
            return Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);
        }
        
        public int getEndTime() {
            return start + playTime;
        }
    }
}