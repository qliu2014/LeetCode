/*

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

*/



class LeetCode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Outer list is arraylist because we need to specify its index
        List<List<Integer>> ans_array = new ArrayList<List<Integer>>(); 
        DFS(root, 0, ans_array);
        return ans_array;
    }
    
    public void DFS(TreeNode root, int depth, List<List<Integer>> ans_array) {
        if (root == null) return;
        //the outer array needs to create (enough) new empty arraylist to host new elements
        while (ans_array.size() <= depth) ans_array.add(new ArrayList<Integer>());
        ans_array.get(depth).add(root.val);
        DFS(root.left, depth + 1, ans_array);
        DFS(root.right, depth + 1, ans_array);
    }
}



/*
 Example
 
    3
   / \
  9   20
     /  \
    15   7
    
    Preorder DFS:
    
    root         depth          ans_array
     3              0               [[3]]
     9              1               [[3], [9]]
     
     20             1               [[3], [9, 20]]
     15             2               [[3], [9, 20], [15]] 
     7              2               [[3], [9, 20], [15, 7]]          
     null           3               return
     
*/
