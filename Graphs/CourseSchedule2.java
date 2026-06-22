import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            topo[index++] = node;

            for (int it : adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return topo;
    }
}

public class CourseSchedule2 {

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        Solution obj = new Solution();

        int[] ans = obj.findOrder(numCourses, prerequisites);

        if (ans.length == 0) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("Course Order:");

            for (int x : ans) {
                System.out.print(x + " ");
            }
        }
    }
}