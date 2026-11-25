class Solution {
    public int findCenter(int[][] arr) {
        int n = arr.length + 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : arr) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for(int i=1; i<=n; i++){
            if(adjList.get(i).size() == n - 1) return i;
        }
        return -1;
    }
}