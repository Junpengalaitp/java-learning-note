package com.junpenghe.data.structure.b.tree;

/**
 * 1. Every node has at most m children.
 * 2. Every node, except for the root and the leaves, has at least m/2 children.
 * 3. The root has at least 2 children (unless it's a leaf).
 * 4. All leaves appear on the same level, and carry no information.
 * 5. A non leaf node with k children contains k - 1 keys.
 *
 * 1. 每个节点最多有m个孩子。
 * 2. 每个内部节点（除去叶节点和根节点）至少有⌈m/2⌉（向上取整）孩子。
 * 3. 如果根不是叶节点，则根至少有两个孩子。
 * 4. 所有叶子都出现在同一层。
 * 5. 具有k个孩子的非叶节点包含k-1个键，当然节点内的键也是递增的。
 */
public class BTree {
}
