class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        HashSet<Integer> out = new HashSet<>();
        for(List<Integer> ele : edges){
            int v = ele.get(1);
            out.add(v);
        }
        for(int i=0; i<n; i++) if(!out.contains(i)) ans.add(i);
        return ans;
    }
}