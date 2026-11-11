class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = queries.length;
        int[][] arr = new int[m][2];
        for (int i=0; i<m; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < m; i++) {
            int qTime = arr[i][0];
            int qIndex = arr[i][1];
            
            int start = qTime - x;
            int end = qTime;

            while (right < logs.length && logs[right][1] <= end) {
                int serverId = logs[right][0];
                map.put(serverId, map.getOrDefault(serverId, 0) + 1);
                right++;
            }

            while (left < logs.length && logs[left][1] < start) {
                int serverId = logs[left][0];
                int count = map.get(serverId);
                if (count == 1) {
                    map.remove(serverId);
                } else {
                    map.put(serverId, count - 1);
                }
                left++;
            }
            ans[qIndex] = n - map.size();
        }
        return ans;
    }
}