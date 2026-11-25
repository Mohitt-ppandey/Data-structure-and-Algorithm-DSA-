class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisted = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++) if(!isVisted[i]) {
            bfs(i , isVisted , isConnected);
            ans++;
        }    
        return ans;
    }
    public void bfs(int i , boolean[] isVisted , int[][] arr){
        isVisted[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int idx=0; idx<arr.length; idx++){
                if(isVisted[idx] == false && arr[front][idx] == 1) {
                    q.add(idx);
                    isVisted[idx] = true;
                }    
            }
        }
    }
}