class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum%k == 0) ans = Math.max(ans , j-i+1);
                int x = ((2*arr[j])%k+k)%k;
                set.add(x);
                int rem = ((sum%k)+k)%k;
                if(set.contains(rem)) ans = Math.max(ans , j-i+1);
            }
        }
        return ans;
    }
}