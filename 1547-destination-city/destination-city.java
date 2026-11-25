class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String , Integer> out = new HashMap<>();
        for(List<String> str : paths){
            String u = str.get(0);
            out.put(u , out.getOrDefault(u , 0)+1);
        }
        for(List<String> str : paths){
            String v = str.get(1);
            if(!out.containsKey(v)) return v;
            if(out.get(v) == 0) return v;
        }
        return "";
    }
}