/*
Given the root of a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.
*/



class LeetCode_199_Iterative_BFS {
      
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightside_array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //if the root is null, return empty array
        if (root == null) return rightside_array;
        
        //add the root to start
        queue.offer(root);
        
        //as long as there are still elements in the queue, we check them
        while (!queue.isEmpty()) {
            
            //before entering the for loop, we check how many elements are on each level
            int levelLength = queue.size();
            
            //only exit the for loop when we finish processing every element on the level
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();  //pop a node from the queue and examine it
                if (i == levelLength - 1) {
                    rightside_array.add(node.val); // this means that we have reached the last node of this level, which is the rightmost node
                }
                
                //add the next level of nodes from left to right
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
   
            }
        }
       
        return rightside_array;
    }
}



