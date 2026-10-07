class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        int[] parent = new int[n];
        int max = 0 , idx = 0;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            parent[i] = -1;
            for(int j=0; j<i; j++){
                if(arr[i] % arr[j] == 0) {
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        parent[i] = j;
                    }
                } 
            }
            if(dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        for(int i=0; i<n; i++) System.out.print(dp[i] + " ");
        List<Integer> ans = new ArrayList<Integer>();
        while(idx != -1){
            ans.add(arr[idx]);
            idx = parent[idx];
        }
        return ans;
    }
}