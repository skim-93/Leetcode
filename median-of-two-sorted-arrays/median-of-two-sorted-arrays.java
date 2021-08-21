class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergeTwoSortedArrays(nums1, nums2);
        return findMedian(merged);
    }
    
    //helper method of merging two sorted array
    
    public int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }
        
        while(i < nums1.length) {
            ans[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            ans[k++] = nums2[j++];
        }
        
        return ans;
    }
    
    //helper method of finding median
    public double findMedian(int[] nums) {
        double median = 0.00;
        
        if(nums.length % 2 == 1) {
            return (double)nums[nums.length/2];
        } else {
            
            median = (double)(nums[nums.length/2 - 1] + nums[nums.length/2])/2 ;
            
            return median;
        }
    }
}