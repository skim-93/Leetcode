class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visit = new boolean[numCourses];
        boolean[] dfsVisit = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList());
        
        for(int[] e : prerequisites) adj.get(e[0]).add(e[1]);
        
        for(int i = 0; i < numCourses; i++) {
            if(!visit[i]) {
                if(cycleDFS(i, adj, visit, dfsVisit)) return false;
            }
        }
        return true;
    }
    
    public boolean cycleDFS(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visit, boolean[] dfsVisit) {
        visit[curr] = true;
        dfsVisit[curr] = true;
        
        for(int v : adj.get(curr)) {
            if(!visit[v]) {
                if(cycleDFS(v, adj, visit, dfsVisit)) return true;
            }
            else if(dfsVisit[v]) return true;
        }
        dfsVisit[curr] = false;
        return false;
    }
}