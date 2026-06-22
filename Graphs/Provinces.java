// package Graphs;

import java.util.*;
class Solution {

    public void dfs(int vertix, int[][] graph, boolean[] vis)
    {
        int n = graph.length;
        vis[vertix] = true;
        for(int neighbour = 0 ; neighbour < n ; neighbour++){
            if(graph[vertix][neighbour] == 1 && vis[neighbour] == false){   
                dfs(neighbour,graph,vis);
            }
        }
    }
    public int findCircleNum(int[][] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];

        int prov = 0;
        for(int i=0 ; i<n ;i++){
            if(!vis[i]){
                prov++;
                dfs(i,graph,vis);
            }
        }
        return prov;
    }
}

public class Provinces {
    public static void main(String[] args) {

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        Solution obj = new Solution();

        int provinces = obj.findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + provinces);
    }
}