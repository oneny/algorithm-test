class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[]{0};
        
        int[] indegree = new int[numCourses];
        int[] answer = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int prevCourse = prerequisite[1];
            int nextCourse = prerequisite[0];
            adjacencyList.get(prevCourse).add(nextCourse);
            indegree[nextCourse]++;
        }
        
        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            answer[index++] = currCourse;
            
            for (int course : adjacencyList.get(currCourse)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        
        if (index != numCourses) return new int[]{};
        return answer;
    }
}