class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int low = 0 , high = arr.length-1;
        while(low <= high){
            String temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return String.join(" " , arr);
    }
}