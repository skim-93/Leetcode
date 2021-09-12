class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        //it is in the sorted order, and I have to return the interval of two list interval.
        
        //I look at the case where it does not intersect, then continue
        
        //there is a case where they would touch it brifly, if end of the slow list is same as the start of the fast list
        
        //there is a case where they intersect, then we put fast start on [0] and end of the slow [1]
        
        // there is a case where it contains all of the intersection so we add all of the end
        
        List<int[]> ans = new ArrayList();
        int i = 0; int j = 0;
        
        while(i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if(lo <= hi) {
                ans.add(new int[]{lo,hi});
            }
            
            if(firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        
        
        return ans.toArray(new int[ans.size()][]);
    }
}