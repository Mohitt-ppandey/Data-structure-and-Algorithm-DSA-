class Solution {
    public int maxEnvelopes(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(ans.isEmpty() || ans.get(ans.size()-1) < arr[i][1]) ans.add(arr[i][1]);
            else addAtLowerBound(arr[i][1] , ans);
        }
        return ans.size();
    }
    public void addAtLowerBound(int x ,  ArrayList<Integer> ans){
        int low = 0 , high = ans.size()-1 , idx = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(ans.get(mid) >= x){
                idx = mid;
                high = mid-1;
            }else low = mid+1;
        } 
        ans.set(idx , x);
    }
}