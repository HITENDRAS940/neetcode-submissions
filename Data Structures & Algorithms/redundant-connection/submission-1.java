class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        this.parent = new int[n+1];
        this.rank = new int[n+1];

        for(int i=1;i<=n;i++) {
            this.parent[i] = i;
        }
    }

    public int find(int i) {
        if(i == parent[i])
            return i;
        
        return parent[i] = find(parent[i]);
    }

    public void union(int x, int y) {
        int x_p = find(x);
        int y_p = find(y);

        if(x_p == y_p) 
            return;

        if(rank[x_p]>rank[y_p]) {
            parent[y_p] = x_p;
        } else if(rank[x_p]<rank[y_p]) {
            parent[x_p] = y_p;
        } else {
            parent[x_p] = y_p;
            rank[y_p]++;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u)==dsu.find(v))
                return edge;
            
            dsu.union(u, v);
        }

        return new int[0];
        
    }
}
