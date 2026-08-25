class Solution {
    public int missingMultiple(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            max = Math.max(max , ele);
            set.add(ele);
        }   
        if(k > max) return k; 
        int ans = 0;
        int i = 1;
        while(i<=max){
            if(!set.contains(k*i)) {
                ans = k*i;
                break;
            }  
            i++;  
        }
        if(ans == 0) return k*i;
        return ans;
    }
}