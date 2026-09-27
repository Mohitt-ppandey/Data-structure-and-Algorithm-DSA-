class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long a = 0 , b = 0;
        for(int ele : source) a = a + ele;
        for(int ele : target) b += ele;
        return a == b;
    }
}