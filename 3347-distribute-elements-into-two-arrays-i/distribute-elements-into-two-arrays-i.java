class Solution {
    public int[] resultArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(arr[0]);
        b.add(arr[1]);
        int i = 2;
        while(i<n){
            if(a.get(a.size()-1) > b.get(b.size()-1)) a.add(arr[i]);
            else b.add(arr[i]);
            i++;
        }
        int[] ans = new int[a.size()+b.size()];
        int j = 0;
        for(int ele : a) ans[j++] = ele; 
        for(int ele : b) ans[j++] = ele; 
        return ans;
    }
}