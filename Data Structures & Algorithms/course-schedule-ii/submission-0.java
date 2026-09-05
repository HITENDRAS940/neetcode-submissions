class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] result = new int[numCourses];

        int index = numCourses-1;
        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int v : graph.get(curr)) {
                inorder[v]--;
                if (inorder[v] == 0)
                    q.offer(v);
            }

            result[index--] = curr;
            count++;
        }

        if (count == numCourses) {
            return result;
        }

        return new int[]{};
    }
}
