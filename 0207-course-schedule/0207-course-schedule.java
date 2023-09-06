class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        
        for (int i = 0; i< numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1], end = prerequisites[i][0];
            adjList[start].add(end);
            indegree[end]++;
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] isInQueue = new boolean[numCourses];
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                isInQueue[i] = true;
            }
        }
        
        while (!queue.isEmpty()) { // BFS
            int courseNum = queue.poll();
            visited[courseNum] = true;
            
            for (int adjCourse : adjList[courseNum]) {
                // 순회하면서 indegree[adjCourse] 인접 개수 하나 줄이고,
                // 처음부터 indegree[adgCourse]가 0이 아닌 경우
                if ((--indegree[adjCourse]) == 0 && !isInQueue[adjCourse]) {
                    queue.add(adjCourse);
                    isInQueue[adjCourse] = true;
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        
        return true;
    }
}