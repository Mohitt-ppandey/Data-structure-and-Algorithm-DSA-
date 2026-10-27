class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sum = new int[13];
        sum[1] = days[0];
        for(int i=2; i<13; i++) sum[i] = sum[i-1] + days[i-1];
        //Alice
        int sm1 = Integer.parseInt(arriveAlice.substring(0,2));
        int sd1 = Integer.parseInt(arriveAlice.substring(3,5));
        int s1 = sum[sm1-1] + sd1;
        int em1 = Integer.parseInt(leaveAlice.substring(0,2));
        int ed1 = Integer.parseInt(leaveAlice.substring(3,5));
        int e1 = sum[em1-1] + ed1;

        //Bob
        int sm2 = Integer.parseInt(arriveBob.substring(0,2));
        int sd2 = Integer.parseInt(arriveBob.substring(3,5));
        int s2 = sum[sm2-1] + sd2;
        int em2 = Integer.parseInt(leaveBob.substring(0,2));
        int ed2 = Integer.parseInt(leaveBob.substring(3,5));
        int e2 = sum[em2-1] + ed2;
        
        int start = Math.max(s1 , s2);
        int end = Math.min(e1 , e2);
        int diff = (end-start)+1;
        return (diff < 0) ? 0 : diff;
    }
}