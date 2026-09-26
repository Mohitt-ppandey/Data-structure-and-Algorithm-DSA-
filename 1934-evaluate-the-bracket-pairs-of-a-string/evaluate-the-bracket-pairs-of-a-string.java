class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map = new HashMap<>();
        for(int i=0; i<knowledge.size(); i++){
            map.put(knowledge.get(i).get(0) , knowledge.get(i).get(1));
        }

        String str = "";
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) != '(') str += s.charAt(i);
            if(s.charAt(i) == '('){
                i++;
                String a = "";
                while(s.charAt(i) != ')'){
                    a += s.charAt(i);
                    i++;
                    if(s.charAt(i) == ')') break;
                }  
                if(map.containsKey(a)) str += map.get(a);
                else str += '?';
            }
            i++;
        }
        return str;
    }
}