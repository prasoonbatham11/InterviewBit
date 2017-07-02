package trees;
import java.util.*;
import java.io.*;
public class MaxDepthOfBinaryTree
{
    public int maxDepth(TreeNode a) {
        if(a==null) return 0;
        int x = maxDepth(a.left);
        int y = maxDepth(a.right);
        return 1+Math.max(x,y);
    }
}
