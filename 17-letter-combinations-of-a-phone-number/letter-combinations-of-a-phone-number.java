class Solution {
    public List<String> letterCombinations(String str) {
        HashMap<Character , List<Character>> map = new HashMap<>();
        char a = 'a';
        for (char ch='2'; ch<='9'; ch++){
            for (int i=1; i<=3; i++){
                if (!map.containsKey(ch)) map.put(ch , new ArrayList<>());
                map.get(ch).add(a++);
            }
            if (ch == '7' || ch == '9') map.get(ch).add(a++);
        }
        List<String> ans = new ArrayList<>();
        //StringBuilder sb = new StringBuilder();
        helper(str ,  "" , map , ans , 0);
        return ans;
    }

    public void helper(String str, String s, HashMap<Character, List<Character>> map , List<String> ans , int idx) {
        if (idx == str.length()) {
            ans.add(s);
            return;
        }
        for (int i=0; i<map.get(str.charAt(idx)).size(); i++) {
            helper(str, s+map.get(str.charAt(idx)).get(i), map, ans, idx + 1);
            //s.deleteCharAt(s.length()-1);
        }
    }
}