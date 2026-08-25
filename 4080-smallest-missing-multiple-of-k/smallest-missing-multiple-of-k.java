class Solution {
    public int missingMultiple(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            max = Math.max(max , ele);
            set.add(ele);
        }   
        if(k > max) return k; 
        int i = 1;
        while(k*i<=max){
            if(!set.contains(k*i)) break; 
            i++;  
        }
        return k*i;
    }
}