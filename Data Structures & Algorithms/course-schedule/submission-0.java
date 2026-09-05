class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inorder = new int[numCourses];

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);

            inorder[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0)
                q.offer(i);
        }

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int v : graph.get(curr)) {
                inorder[v]--;
                if (inorder[v] == 0)
                    q.offer(v);
            }

            count++;
        }

        return count==numCourses;
    }
}
