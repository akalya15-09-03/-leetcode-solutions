class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
          
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] ind = new int[V];
        for(int i = 0; i < V; i++){
            for(int n : adj.get(i)){
                ind[n]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;         
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int neighbor : adj.get(node)){
                ind[neighbor]--;
                
                if(ind[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return count == V;
    }
}