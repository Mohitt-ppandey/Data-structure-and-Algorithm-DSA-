class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;
        int sortArr[] = new int[total];
        int i = 0, j = 0, k=0;
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                sortArr[k++] = nums1[i];
                i++;
            }else{
                sortArr[k++] = nums2[j];
                j++;
            }
        }
        while(i<n1){
            sortArr[k++] = nums1[i++];
        }
        while(j<n2){
            sortArr[k++] = nums2[j++];
        }
        int a = total/2 - 1;
        int b = total/2;
        if(total % 2 == 0){
            return ((double)sortArr[a] + (double)sortArr[b])/2;
        }else{
            double median = sortArr[b];
            return median;
        }
    }
}