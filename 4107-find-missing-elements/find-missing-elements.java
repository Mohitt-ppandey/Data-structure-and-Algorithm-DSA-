class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int ele : arr){
            min = Math.min(ele , min);
            max = Math.max(ele , max);
        } 
        for(int i=min; i<=max; i++){
            if(!set.contains(min)) ans.add(min);
            min++;
        }
        return ans;
    }
}