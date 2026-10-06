class Solution {
    public boolean searchMatrix(int[][] arr, int x) {
        int low = 0 , high = arr[0].length-1 , idx = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[0][mid] == x) return true;
            else if(arr[0][mid] < x){
                idx = mid;
                low = mid +1;
            }else high = mid - 1;
        }
        if(arr.length == 1) return false;
        for(int i=0; i<arr.length; i++){
            low = 0;
            high = idx;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[i][mid] == x) return true;
                else if(arr[i][mid] < x){
                    low = mid +1;
                }else high = mid - 1;
            }
        }
        return false;
    }
}