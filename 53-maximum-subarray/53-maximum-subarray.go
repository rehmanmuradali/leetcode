func maxSubArray(nums []int) int {
    
    // -2,1,-3,4,-1,2,1,-5,4
    // -2 1.-2 4. 3.5 6. 1 5
    
    sum := 0
	max := nums[0]
	for i := 0; i < len(nums); i++ {
		if sum < 0 {
			sum = nums[i]
		} else {
			sum += nums[i]
		}
		max = int(math.Max(float64(max), float64(sum)))
	}
	return max
}