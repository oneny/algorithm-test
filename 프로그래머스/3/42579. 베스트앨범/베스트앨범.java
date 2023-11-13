import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<Genre>> queueMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            PriorityQueue<Genre> qMap = queueMap.get(genres[i]);

            if (qMap == null) {
                qMap = new PriorityQueue<>((o1, o2) -> {
                    if (o2.plays == o1.plays) {
                        return o1.id - o2.id;
                    }

                    return o2.plays - o1.plays;
                });

                queueMap.put(genres[i], qMap);
            }

            qMap.offer(new Genre(i, plays[i]));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        ArrayList<Integer> answer = new ArrayList<>();

        for (String s : list) {
            answer.add(queueMap.get(s).poll().id);
            if (queueMap.get(s).size() != 0) {
                answer.add(queueMap.get(s).poll().id);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Genre {
        int id;
        int plays;

        public Genre(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }                                                                                           
}