/*

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

*/

class LeetCode_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        
        // one of p and q is null -> meaning structurally not identical
        if (p == null || q == null) return false;
        
        // if same structure, compare value at the node
        if (p.val != q.val) return false;
        
        // if value is the same, recursively check its child nodes and other descendants
        // both left sub tree and right sub tree must satisfy
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
