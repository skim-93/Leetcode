class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        vector<int> answer;
        for(auto firstCount = 0; firstCount < nums.size(); ++firstCount) {
            for(auto secondCount = firstCount + 1; secondCount < nums.size(); ++secondCount) {
                if(target == (nums[firstCount] + nums[secondCount])) {
                    answer.push_back(firstCount);
                    answer.push_back(secondCount);
                    return answer;
                }
            }
        }
        
        
        return answer;
        
    }
};