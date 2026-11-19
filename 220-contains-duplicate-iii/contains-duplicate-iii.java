class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int valueDiff) {
        int n = arr.length;
        if(k <= 0 || valueDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        int i=0 , j=0;
        while(j<n){
            long x = arr[j];
            Long candidate = set.ceiling(x - valueDiff);
            if (candidate != null && candidate <= x + valueDiff) return true;
            set.add(x);
            if(j-i < k) j++;
            else {
                set.remove((long)(arr[i]));
                i++;
                j++;
            }
        }
        return false;
    }
}