/*

Given the root of a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

*/


class LeetCode_199_Recursive_DFS {
    
    List<Integer> rightside_array = new ArrayList<>(); // instantiate here so both functions can access this variable
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside_array;
        // recursive helper function
        DFS(root, 0);
        return rightside_array;
    }
    
    public void DFS(TreeNode node, int level) {
        if (level == rightside_array.size()) //if current level has been visited before, meaning the rightmost element has been added to the list, we don't add any more elements to its left even if there is any
            rightside_array.add(node.val);
        
        //traverse right child first to ensure that the rightmost child gets added to the array first
        if (node.right != null)
            DFS(node.right, level + 1);
        
        if (node.left != null)
            DFS(node.left, level + 1);
                
    }
}

/*

    Method 1: implement BFS with queue, with Level.size()
    Method 2: DFS recursively

*/