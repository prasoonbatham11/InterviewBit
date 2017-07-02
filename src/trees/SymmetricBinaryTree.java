package trees;
import java.util.*;
import java.io.*;
public class SymmetricBinaryTree
{
    public static int isSymmetric(TreeNode a)
    {
        if(a==null) return 1;

        TreeNode b = new TreeNode(a.val);

        LinkedList<TreeNode> res = new LinkedList<>();
        res.add(a);res.add(b);

        while(!res.isEmpty())
        {
            TreeNode x = res.poll();
            TreeNode y = res.poll();
            if(x.left!=null) {
                res.add(x.left);
                y.left = new TreeNode(x.left.val);
                res.add(y.left);
            }
            if(x.right!=null) {
                res.add(x.right);
                y.right = new TreeNode(x.right.val);
                res.add(y.right);
            }
        }

        b = mirror(b);


        return isSameTree(a, b);

    }
    public static TreeNode mirror(TreeNode a)
    {
        if(a==null) return a;

        TreeNode left = mirror(a.left);
        TreeNode right = mirror(a.right);

        a.left = right;
        a.right = left;

        return a;
    }
    public static int isSameTree(TreeNode a, TreeNode b) {

        if(a==null && b==null) return 1;

        if(a!=null && b!=null) {
            int x, y, z;
            x = 0;
            if(a.val==b.val) x = 1;
            y = isSameTree(a.left, b.left);
            z = isSameTree(a.right, b.right);
            if(x==1 && y==1 && z==1) return 1;
            else return 0;
        }
        return 0;
    }
}
