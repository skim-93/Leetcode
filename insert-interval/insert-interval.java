class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        boolean intervalAdded = false;
        int start = newInterval[0], end = newInterval[1];
        
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]){
                if(!intervalAdded) {
                    res.add(new int[]{start, end});
                    intervalAdded = true;
                }
                res.add(intervals[i]);
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        if(!intervalAdded) {
            res.add(new int[]{start, end});
        }
        
        
        return res.toArray(new int[0][0]);
    }
}