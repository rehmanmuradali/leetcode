class Solution {
       public int[] rotate(int[] nums, int k) {
        int n=nums.length;
        if(k > n) 
            k=k%n;
        nums=reverse(nums, 0, n-1);
        nums=reverse(nums, 0, k-1);
        nums=reverse(nums, k, n-1);
        return nums;        
    }
    
    public int[] reverse(int[] nums, int start, int end) {
       while (start <= end ) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums; 
    }
}