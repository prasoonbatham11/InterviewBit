package trees;
import java.util.*;
import java.io.*;
public class InvertTheBinaryTree
{
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
