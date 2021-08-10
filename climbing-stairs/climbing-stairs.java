class Solution {
    public int climbStairs(int n) {
        //at 2 steps, there are 2 way, which is steps from 1 and steps from 0
        //at 3 steps, there are 3 way which is steps from 1 and steps from 2 added.
        //at 4 steps -> at step 2 + at step 3
        //because we can only go one or two steps, we have to find the base step which is at step 2
        
        int[] stepList = new int[n + 1];
        stepList[0] = 1;
        stepList[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            stepList[i] = stepList[i-1] + stepList[i-2];
        }
        
        return stepList[n];
    }
}