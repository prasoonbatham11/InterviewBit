package trees;
import java.util.*;
import java.io.*;
public class PathSum
{
    public static int hasPathSum(TreeNode a, int b)
    {
        if(a.left==null && a.right ==null && b-a.val==0) return 1;

        int x = 0, y = 0;
        if(a.left!=null) x = hasPathSum(a.left, b-a.val);
        if(a.right!=null) y = hasPathSum(a.right, b-a.val);

        if(x==1 || y==1) return 1;
        return 0;
    }
}
