import java.util.*;

class Solution {
    
    private List<Score> scoreList = new ArrayList<>();
    
    public int solution(int[][] scores) {
        
        for (int[] score : scores) {
            scoreList.add(new Score(score[0], score[1]));
        }
        
        Collections.sort(scoreList);
        
        return getWanHoRank(new Score(scores[0][0], scores[0][1]));
    }
    
    private int getWanHoRank(Score wanHo) {
        int maxPeerPoint = 0;
        int ranking = 0;
        
        for (Score s : scoreList) {
            // 동료 점수가 낮아진 경우에는 태도 점수가 이전보다 낮아진 경우이기도 하고,
            // 동료 점수도 자신보다 높기 때문에 인센티브를 받을 수 없다.
            if (maxPeerPoint > s.peer) {
                if (s.equals(wanHo)) { // 완호의 점수와 같다면 -1 반환
                    return -1;
                }
            } else {
                // 태도 점수 같다면 동료 점수만 비교하면서
                // 최대 동료 점수보다 동료 점수가 높다면 최대 동료 점수 갱신
                // 완호의 총합과 비교 후 완호보다 더 큰 score면 개수를 세어줌
                maxPeerPoint = Math.max(maxPeerPoint, s.peer);
                if (wanHo.getSum() < s.getSum()) {
                    ranking += 1;
                }
            }
        }
        
        return ranking + 1;
    }
    
    class Score implements Comparable<Score> {
        int attitude;
        int peer;
        
        public Score(int attitude, int peer) {
            this.attitude = attitude;
            this.peer = peer;
        }
        
        // 태도 점수 내림차순 정렬, 같으면 동료 점수 오름차순 정렬
        @Override
        public int compareTo(Score s) {
            if (attitude == s.attitude) {
                return peer - s.peer;
            }
            
            return s.attitude - attitude;
        }
        
        public boolean equals(Score s) {
            return attitude == s.attitude && peer == s.peer;
        }
        
        public int getSum() {
            return attitude + peer;
        }
    }
}