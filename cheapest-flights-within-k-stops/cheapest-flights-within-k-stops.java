class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map <Integer, Integer> visited = new HashMap<>(); 
        
        for (int[] flight: flights) {
            graph.putIfAbsent(flight[0], new ArrayList<int[]>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        
        pq.add(new int[] {src, 0, 0});
        
        
         while (!pq.isEmpty()) {
            int [] arr = pq.poll(); 
            int curr = arr[0]; 
            int cost = arr[1]; 
            int stop = arr[2]; 
            
            if (dst == curr) return cost;
             
            if (visited.containsKey(curr) && visited.get(curr) < stop) continue; 
                visited.put(curr, stop); 
            
            if (stop > k)  continue;
             
            if (!graph.containsKey(curr)) continue; 
             
            for (int [] flight : graph.get(curr)) 
                  pq.offer(new int []{flight[0], cost + flight[1], stop+1});    
            }
        
       return -1; 
    }
}