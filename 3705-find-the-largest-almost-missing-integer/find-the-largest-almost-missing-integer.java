class Solution {
    public int largestInteger(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        if(k == n) {
            for(int ele : arr) ans = Math.max(ele , ans);
            return ans;
        } 
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int ele : arr) map.put(ele , map.getOrDefault(ele , 0)+1);
        if(k == 1 && map.size() == 1) return -1;
        if(k == 1 && map.size() > 1) {
            for(int ele : arr) if(map.get(ele) == 1) ans = Math.max(ans , ele);
            return ans;
        }

        if(map.get(arr[0]) > 1 && map.get(arr[n-1]) > 1) return -1;
        else if(map.get(arr[0]) == 1 && map.get(arr[n-1]) > 1) return arr[0];
        else if(map.get(arr[0]) > 1 && map.get(arr[n-1]) == 1) return arr[n-1];
        else return Math.max(arr[0] , arr[n-1]);
    }
}