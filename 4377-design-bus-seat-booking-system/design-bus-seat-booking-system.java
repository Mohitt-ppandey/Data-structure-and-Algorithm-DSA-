class BusBooking {
    static boolean[][] isBooked;
    static int[][] cost;
    static int time;
    static int totalCost;
    public BusBooking(int n) {
        isBooked = new boolean[n+1][4];
        cost = new int[n+1][4];
        time = 0;
        totalCost = 0;
    }
    
    public void toggle(String seat) {
        int j = seat.charAt(0) - 'A';
        int i = Integer.parseInt(seat.substring(1));
        if(isBooked[i][j]) {
            time -= cost[i][j];
            totalCost--;
            cost[i][j] = 0;
            isBooked[i][j] = false;

        }else {
            if(j == 0 && isBooked[i][j+1]){
                cost[i][j] = 3;
                time += 3;
            }else if(j == 3 && isBooked[i][j-1]){
                cost[i][j] = 3;
                time += 3;
            }else {
                cost[i][j] = 1;
                time++;
            }    
            totalCost++;
            isBooked[i][j] = true;
        }
    }
    
    public int getTotalTime() {
        return time;
    }
    
    public int getMinTime() {
        return totalCost;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */