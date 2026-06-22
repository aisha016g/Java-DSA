import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        // Calculate indegree
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Push all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            count++;

            for (int it : adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return count == numCourses;
    }
}

public class CourseSchedule1 {

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {3, 2}
        };

        Solution obj = new Solution();

        boolean ans = obj.canFinish(numCourses, prerequisites);

        System.out.println(ans);
    }
}