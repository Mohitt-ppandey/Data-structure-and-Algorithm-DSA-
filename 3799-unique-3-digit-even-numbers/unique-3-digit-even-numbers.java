class Solution {
    public int totalNumbers(int[] arr) {
        int[] freq = new int[10];
        int ans = 0;
        for(int ele : arr) freq[ele]++; 
        for(int i=100; i<1000; i++){
            if(i%2 == 0){
                int n = i;
                int a = n%10;
                n /= 10;
                int b = n%10;
                n /= 10;
                int c = n%10;
                int[] check = new int[10];
                check[a]++;
                check[b]++;
                check[c]++;
                boolean flag = true;
                for(int j=0; j<10; j++) if(check[j] > freq[j]) flag = false;
                if(flag) ans++;
            }
        }
        return ans;
    }
}