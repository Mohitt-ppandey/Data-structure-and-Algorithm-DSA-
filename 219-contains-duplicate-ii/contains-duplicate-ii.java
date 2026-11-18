class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        int i=0 , j=0;
        while(j<n){
            if(map.containsKey(arr[j]) && map.get(arr[j]) > 0) return true;
            map.put(arr[j] , map.getOrDefault(arr[j] , 0)+1);
            if(j-i < k) j++;
            else {
                map.put(arr[i] , map.get(arr[i])-1);
                i++;
                j++;
            }
        }
        return false;
    }
}