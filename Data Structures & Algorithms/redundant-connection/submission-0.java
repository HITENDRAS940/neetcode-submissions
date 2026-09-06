class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[n];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(map.containsKey(u) && map.containsKey(v) && dfs(map, u, v, new boolean[n + 1])) {
                return edge;
            }

            map.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }

        return new int[0];    
    }

    private boolean dfs(
        HashMap<Integer, List<Integer>> map,
        int source,
        int target,
        boolean[] visited
    ) {
        visited[source] = true;

        if(source == target)
            return true;

        for(int ngbr : map.get(source)) {
            if(!visited[ngbr] && dfs(map, ngbr, target, visited))
                return true;
        }

        return false;
    }
}
