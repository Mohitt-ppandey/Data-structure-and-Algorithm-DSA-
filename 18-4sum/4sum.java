class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j>i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1 , m = n-1;
                while(k < m){
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[m];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        list.add(arr[m]);
                        ans.add(new ArrayList<>(list));
                        k++;
                        m--;
                        while(k < m && arr[k] == arr[k-1]) k++;
                        while(k < m && arr[m] == arr[m+1]) m--;
                    }
                    if(sum < target) k++;
                    else if(sum > target) m--;
                }
            } 
        }
        return ans;
    }
}