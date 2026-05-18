class Solution {

    private boolean dfscheck(int node,int[][] graph,int[] vis,int[] pathvis,int[] check){
        vis[node] = 1;
        pathvis[node] = 1;
        check[node] = 0;

        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfscheck(it,graph,vis,pathvis,check)){
                    return true;
                }
            }
                else if(pathvis[it] == 1){
                    return true;
                }
            }
            check[node] =1;
            pathvis[node] = 0;
            return false;

           
        }
         
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        int[] check = new int[v];

        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                dfscheck(i,graph,vis,pathvis,check);
            }
        }

        List<Integer> safenodes = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i] == 1) safenodes.add(i);
        }
        return safenodes;
        
    }
}