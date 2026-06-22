import java.util.*;

public class MergeIntervals {

    // ================== BRUTE FORCE ==================
    public static List<int[]> brute(int[][] intervals) {
        int n = intervals.length;
        boolean[] visited = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = i + 1; j < n; j++) {

                if (visited[j]) continue;

                // Check overlap
                if (Math.max(start, intervals[j][0]) <= Math.min(end, intervals[j][1])) {

                    // Merge
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);

                    visited[j] = true;
                }
            }

            result.add(new int[]{start, end});
        }

        return result;
    }


    // ================== OPTIMAL ==================
   public static int[][] optimal(int[][] intervals) {

    if (intervals.length == 0) return new int[0][0];

    // Step 1: Sort by starting time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> result = new ArrayList<>();

    // Step 2: Add first interval
    result.add(intervals[0]);

    // Step 3: Traverse and merge
    for (int i = 1; i < intervals.length; i++) {

        int[] last = result.get(result.size() - 1);
        int[] curr = intervals[i];

        if (curr[0] <= last[1]) {
            // Merge
            last[1] = Math.max(last[1], curr[1]);
        } else {
            result.add(curr);
        }
    }

    // 🔥 IMPORTANT: return result
    return result.toArray(new int[result.size()][]);
}

public static int[][] optimal1(int[][] intervals) {

    if (intervals.length == 0) return new int[0][0];

    // Step 1: Sort
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> result = new ArrayList<>();

    for (int i = 0; i < intervals.length; i++) {

        // If result empty OR no overlap
        if (result.isEmpty() || intervals[i][0] > result.get(result.size() - 1)[1]) {
            result.add(intervals[i]);
        } 
        else {
            // Merge
            result.get(result.size() - 1)[1] = 
                Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
        }
    }

    return result.toArray(new int[result.size()][]);
}
    // ================== MAIN ==================
    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        // Brute
        System.out.println("Brute Force:");
        List<int[]> bruteAns = brute(intervals);
        for (int[] i : bruteAns) {
            System.out.println(i[0] + " " + i[1]);
        }

        // Optimal
        System.out.println("\nOptimal:");
        int[][] optimalAns = optimal(intervals);
        for (int[] i : optimalAns) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
