class Solution {
    public boolean canJump(int[] nums) {
	if(nums.length == 1) return true;
	int furthestPos = 0;

	for(int i = 0; i < nums.length - 1; i++){
		if(nums[i] == 0 && i == furthestPos) return false;
		furthestPos = Math.max(furthestPos, i + nums[i]);
		if(furthestPos >= nums.length - 1) return true;
	}
	return false;
}
}