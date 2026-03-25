import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int nei : adj.get(i)){
                indegree[nei]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            result[index++] = node;
            
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        if(index == numCourses){
            return result; 
        }
        
        return new int[0]; 
    }
}