class Solution {
    public int maxArea(int[] height) {
         int start = 0, end = height.length - 1;
        long maxArea = -1;

        while(start < end ) {
            int minHeight = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, (long) minHeight * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return (int)maxArea;
    }
}