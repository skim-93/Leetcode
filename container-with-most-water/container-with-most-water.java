class Solution {
    public int maxArea(int[] height) {
        //two pointer, left right
        int start = 0;
        int end = height.length - 1;
        int max = 0;
    
        // find area, add to max, move min of left and right
        while(start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max,area);
            
            if(height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
            
        }
        
        return max;
    }
}