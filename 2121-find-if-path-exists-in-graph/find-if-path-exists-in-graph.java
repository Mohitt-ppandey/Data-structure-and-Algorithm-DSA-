class Solution {
    public boolean validPath(int n, int[][] arr, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<arr.length; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        boolean ans = false;
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()){
            int top = q.remove();
            for(int ele : adj.get(top)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
            if(vis[destination]) return true;
        }
        return false;
    }
}