package trees;
import java.util.*;
import java.io.*;
public class MinDepthOfBinaryTree
{
    public static int minDepth(TreeNode a)
    {
        if(a==null) return 0;

        if(a.left==null && a.right==null) return 1;

        if(a.left==null) return 1+minDepth(a.right);
        if(a.right==null) return 1+minDepth(a.left);

        return 1+Math.min(minDepth(a.left), minDepth(a.right));
    }
}
