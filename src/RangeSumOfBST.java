/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class RangeSumOfBST {
    
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

     public static int visit(TreeNode node, int low, int high){
        int temp=0;
        if(node.val >= low && node.val <= high){
            temp += node.val;
        }
        if(node.left != null && node.val > low){
            temp += visit(node.left, low, high);
        }
        if(node.right != null && node.val < high){
            temp += visit(node.right, low, high);
        }
        return temp;
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        return visit(root, low, high);
    }

    public static void main(String[] args){
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
        //Memory Usage: 63.9 MB, less than 19.54% of Java online submissions for Range Sum of BST.
    }
}
