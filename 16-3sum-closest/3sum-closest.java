class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1 , k = n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                int dif = Math.abs(target - sum);
                if(diff >= dif) {
                    ans = sum;
                    diff = dif;
                }   
                if(sum == target) return sum;
                else if(sum < target) j++;
                else k--;
                // while(j<n && arr[j] == arr[j-1]) j++;
                // while(k<=0 && arr[k] == arr[k+1]) k--;
            }
        }
        return ans;
    }
}