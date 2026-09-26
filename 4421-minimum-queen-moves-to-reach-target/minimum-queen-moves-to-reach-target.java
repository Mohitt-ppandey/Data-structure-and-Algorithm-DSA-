class Solution {
    public int minQueenMoves(int[] src, int[] dst) {
        int x = Math.abs(src[0] - dst[0]);
        int y = Math.abs(src[1] - dst[1]);
        if(x ==0 && y == 0) return 0;
        if(x == 0 || y == 0) return 1;
        if(x == y) return 1;
        return 2;
    }
}