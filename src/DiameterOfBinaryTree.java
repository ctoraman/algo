/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.*;
class DiameterOfBinaryTree {

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

    public int subLength(TreeNode node){
        if( node == null){
            return 0;
        }
        if( node.left == null && node.right == null){
            return 0;
        }
        return 1 + Math.max( subLength(node.left), subLength(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Set<TreeNode> visited = new HashSet<TreeNode>();
        int max=-1;
        while( !queue.isEmpty()){
            TreeNode node = queue.remove();
            int length;
            if( node.left != null && node.right != null){
                length = subLength(node.left) + subLength(node.right) + 2;
            }else if( node.left != null){
                length = subLength(node.left) + 1;
            }else if( node.right != null){
                length = subLength(node.right) + 1;
            }else{
                length = 0;
            }

            if( length > max){
                max = length;
            }
            if( !visited.contains(node.left) && node.left != null){
                queue.add(node.left);
            }
            if( !visited.contains(node.right) && node.right != null){
                queue.add(node.right);
            }
        }
        return max;
    }
}