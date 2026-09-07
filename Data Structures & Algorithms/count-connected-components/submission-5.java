class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if(i==parent[i])
            return i;

        return parent[i] = find(parent[i]);
    }
    
    public void union(int x, int y) {
        int x_p = find(x);
        int y_p = find(y);

        if(x_p == y_p) {
            return;
        }

        int rankx = rank[x_p];
        int ranky = rank[y_p];

        if(rankx > ranky) {
            parent[y_p] = x_p;
        } else if(rankx < ranky) {
            parent[x_p] = y_p;
        } else {
            parent[x_p] = y_p;
            rank[y_p]++;
        }
    }

    public int countDistinctParent() {
        Set<Integer> set = new HashSet<>();
        for(int i =0 ;i<parent.length;i++)
            set.add(find(i));
        
        return set.size();

    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        return dsu.countDistinctParent();

    }
}
