class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr , (a , b) -> (a[0]!=b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] ele : arr){
            if(ans.size() == 0 || ele[1] > ans.get(ans.size()-1)) ans.add(ele[1]);
            else replace(ele[1] , ans);
        }
        return ans.size();
    }
    public void replace(int a , ArrayList<Integer> ans){
        int low = 0 , high = ans.size()-1 , x = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(ans.get(mid) >= a){
                x = mid;
                high = mid-1;
            }else low = mid+1;
        }
        ans.set(x , a);
    }
}