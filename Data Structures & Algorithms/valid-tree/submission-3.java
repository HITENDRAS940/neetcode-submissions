class Solution {
    private boolean dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int v : map.getOrDefault(node, new ArrayList<>())) {
            if (v == parent)
                continue;
            if (visited[v])
                return true;

            if (dfs(map, v, visited, node))
                return true;
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(map, i, visited, -1))
                return false;
        }

        return true;
    }
}
