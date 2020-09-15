package src.graph.unionfind;

import lombok.Data;

/**
 * 并查集
 * 解决动态连通图问题
 */
@Data
public class UnionFind {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(6);
        uf.union(1, 4);
        uf.union(2, 3);
        uf.union(3, 5);
        System.out.println(uf.connected(1, 5));
        System.out.println(uf.connected(2, 5));
        System.out.println(uf.getCount());
    }

    // 存储父节点
    private int[] parent;
    // 存储节点数
    private int[] size;
    // 连通分量
    private int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
//        while (parent[x] != x)
//            x = parent[x];
//        return x;
        return parent[x] == x ? x : find(parent[x]);
    }

    public int compressAndFind(int x) {
        while (parent[x] != x) {
            // 压缩树的高度
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot) return;

        // 小树接到大树下面更平衡
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        count--;
    }

    public boolean connected(int q, int p) {
        return compressAndFind(q) == compressAndFind(p);
    }
}
