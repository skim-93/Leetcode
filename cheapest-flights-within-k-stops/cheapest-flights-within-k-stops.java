class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Integer> cost = new HashMap();
        for(int[] f : flights) {
            cost.put(f[0], Integer.MAX_VALUE);
            if(!cost.containsKey(f[1])) {
                cost.put(f[1], Integer.MAX_VALUE);
            }
        }
        
        cost.put(src, 0);
        
        for(int i = 0; i <= k; i++) {
            Map<Integer, Integer> temp = new HashMap();
            temp.putAll(cost);
            for(int[] f : flights) {
                int current = f[0];
                int next = f[1];
                int price = f[2];
                
                if(cost.get(current) != Integer.MAX_VALUE) {
                    temp.put(next,  Math.min(temp.get(next), cost.get(current) + price));
                }
            }
            cost = temp;
        }
        if( cost.get(dst) == null || cost.get(dst) == Integer.MAX_VALUE) return -1;
        else return cost.get(dst);
    }
}