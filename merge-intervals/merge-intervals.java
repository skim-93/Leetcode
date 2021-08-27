class Solution {
    public int[][] merge(int[][] intervals) {
        //is given integer sorted?
        // find out the cases
        // case 1: when current end is bigger than next start, then we check next end, if it is currentend < nextend we set current start = current start, current end as next end
        // case 2: when current end is bigger but they are also bigger than next end, then we just continue to next without adding 
        // case 3: current end is smaller than next start, then we just add that to the list
        
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        int currentStart = intervals[0][0]; 
        int currentEnd = intervals[0][1];
        int i = 0;
        
        while(i < intervals.length) {
            if(i < intervals.length -1) {
                int nextStart = intervals[i+1][0];
                int nextEnd = intervals[i+1][1];
            
                if(currentEnd >= nextStart && currentEnd >= nextEnd) {
                    i++;
                } else if(currentEnd >= nextStart && currentEnd < nextEnd) {
                    currentEnd = nextEnd;
                    i++;
                } else {
                    int [] curr = new int[2];
                    curr[0] = currentStart;
                    curr[1] = currentEnd;
                    res.add(curr);
                    currentStart = nextStart;
                    currentEnd = nextEnd;
                    i++;
                }
            } else {
                    int [] curr = new int[2];
                    curr[0] = currentStart;
                    curr[1] = currentEnd;
                    res.add(curr);
                i++;
            }
            
        }
                
        return res.toArray(new int[res.size()][]);
    }
}