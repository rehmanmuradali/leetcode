func missingNumber(nums []int) int {
	n := len(nums)
    sum := (n*(n+1))/2 
    for i := range nums {
		sum -= nums[i]
	}
	return sum
}