class Solution {
    private int find(int v, int[] parent) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v], parent);
    }

    private boolean unionSets(int a, int b, int[] parent, int[] size) {
        a = find(a, parent);
        b = find(b, parent);
        if (a != b) {
            if (size[a] < size[b]) {
                int temp = a; a = b; b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
            return true;
        }
        return false;
    }

    public int maxStability(int n, int[][] edges, int k) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int comp = n;
        int res = Integer.MAX_VALUE;
        List<int[]> opt = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                if (unionSets(edge[0], edge[1], parent, size)) {
                    comp--;
                    res = Math.min(res, edge[2]);
                } else {
                    return -1;
                }
            }
        }

        if (comp == 1) {
            return res;
        }

        for (int[] edge : edges) {
            if (edge[3] == 0) {
                opt.add(edge);
            }
        }

        opt.sort((a, b) -> b[2] - a[2]);

        List<Integer> stab = new ArrayList<>();
        for (int[] edge : opt) {
            if (unionSets(edge[0], edge[1], parent, size)) {
                comp--;
                stab.add(edge[2]);
                if (comp == 1) break;
            }
        }

        if (comp > 1) {
            return -1;
        }
        for (int i = 1; i <= k && i <= stab.size(); i++) {
            int idx = stab.size() - i;
            stab.set(idx, stab.get(idx) * 2);
        }

        int minStab = Integer.MAX_VALUE;
        for (int val : stab) {
            minStab = Math.min(minStab, val);
        }

        return Math.min(res, minStab);
    }
}
