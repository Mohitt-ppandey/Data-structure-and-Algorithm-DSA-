class Solution {
      public static int minSwaps(int[] arr) {
        int n = arr.length;
        Integer[] afterSort = new Integer[n];
        for(int i=0; i<n; i++) afterSort[i] = arr[i];
        Arrays.sort(afterSort , new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                int sum1 = getDigitSum(a);
                int sum2 = getDigitSum(b);
                if (sum1 != sum2) return Integer.compare(sum1 , sum2);
                return Integer.compare(a , b);
            }
        });
        int count = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(arr[i] , i);
        for (int i=0; i<n; i++){
            if (arr[i] != afterSort[i]){
                int j = map.get(afterSort[i]);
                map.put(arr[i] , j);
                map.put(afterSort[i] , i);
                swap(i , j , arr);
                count++;
            }
        }
        return count;
    }
    public static int getDigitSum(int n) {
        int x = n;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    public static void swap(int i , int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}