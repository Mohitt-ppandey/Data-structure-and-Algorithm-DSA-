class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder str = new StringBuilder();
            for (int i=0; i<s.length(); i += k) {
                String subStr = s.substring(i, Math.min(i + k, s.length()));
                int sum = 0;
                for (char ch : subStr.toCharArray()) sum += ch - '0';
                str.append(sum);
            }
            s = str.toString();
        }
        return s;
    }
}