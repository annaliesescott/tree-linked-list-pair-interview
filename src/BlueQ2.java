public class BlueQ2 {
    /**
     * Returns which has a higher range: a given linked list or a given tree.
     * The range of a data structure is the difference between its highest
     * value and its lowest value.
     * 
     * Returns "list" if the list has a higher range and "tree" if the tree has
     * a higher range. You can assume there will not be a tie, and neither head
     * nor root will be null.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "list"
     * 
     * Explanation:
     *   The largest number in the list is 21 and -2 is the smallest.
     *   Thus the range of the list is 21 - -2 = 23
     *   The largest number in the tree is 18, and 4 is the smallest.
     *   Thus the range of the tree is 18 - 4 = 14
     *   23 is bigger than 14, so the list has the bigger range.
     *    
     * 
     * @param head the head of the list
     * @param root the root of the tree
     * @return "list" if the list has a bigger range, "tree" otherwise
     */
    public static String biggerRange(ListNode head, TreeNode root) {
        ListNode current = head;
        int min = head.data;
        int max = head.data;
        while(current != null){
            if(current.data<min){
                min = current.data;
            }
            if(current.data>max){
                max = current.data;
            }
            current = current.next;
        }
        int listRange = max-min;
        int treeRangeMax = treeRangeMax(root);
        int treeRangeMin = treeRangeMin(root);
        int treeRange = treeRangeMax-treeRangeMin;
        if(listRange>treeRange){
            return "list";
        }
        return "tree";

    }

    public static int treeRangeMin(TreeNode root){
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = treeRangeMin(root.left);
        int rightMin = treeRangeMin(root.right);
        int min = root.data;
        min = Math.min(min, leftMin);
        min = Math.min(min, rightMin);
        return min;
    }

    public static int treeRangeMax(TreeNode root){
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = treeRangeMax(root.left);
        int rightMax = treeRangeMax(root.right);
        int max = root.data;
        max = Math.max(max, leftMax);
        max = Math.max(max, rightMax);
        return max;
    }


}
