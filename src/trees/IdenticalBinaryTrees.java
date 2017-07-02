package trees;
import java.util.*;
import java.io.*;
public class IdenticalBinaryTrees
{
    public int isSameTree(TreeNode a, TreeNode b) {

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
