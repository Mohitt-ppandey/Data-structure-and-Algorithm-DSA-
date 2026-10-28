class Solution {
    public long minSumSquareDiff(int[] arr1, int[] arr2, int k1, int k2) {
        int n = arr1.length;
        int[] diff = new int[n];
        for(int i=0; i<n; i++) diff[i] = Math.abs(arr1[i]-arr2[i]);
        long count = k1+k2;
        int[] ans = new int[(int)1e5+1];
        for(int i=0; i<n; i++) ans[diff[i]]++;
        for(int i=ans.length-1; i>=0; i--){
            if(ans[i] != 0){
                long opr = Math.min(count , ans[i]);
                ans[i] -= (int)opr;
                if(i>0) ans[i-1] += (int)opr;
                count -= opr;
            }
            if(count == 0) break;
        }
        long sum = 0;
        for(int i=0; i<ans.length; i++) {
            if(ans[i] != 0) sum += (long) ans[i] * i * i;;
        }
        
        return sum;
    }
}