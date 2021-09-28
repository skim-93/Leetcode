var climbStairs = function(n) {
    const recursive = (steps, memo) => {
        if(steps in memo) return memo[steps];
        if(steps > n) {
            memo[steps] = 0;
            return 0;
        }
        if(steps == n) {
            memo[steps] = 1;
            return 1;
        }
        
        memo[steps+1] = recursive(steps + 1, memo);
        memo[steps+2] = recursive(steps + 2, memo);
        return memo[steps+1] + memo[steps+2];
    }
    
    return recursive(0, {});
};