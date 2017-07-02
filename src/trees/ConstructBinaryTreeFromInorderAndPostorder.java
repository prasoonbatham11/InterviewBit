package trees;
import java.util.*;
import java.io.*;
public class ConstructBinaryTreeFromInorderAndPostorder
{
    static int x = 0;
    public static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> pre)
    {
        x = pre.size()-1;
        return build(pre, in, 0, pre.size()-1);
    }

    public static TreeNode build(ArrayList<Integer> pre, ArrayList<Integer> in,
                                 int start, int end)
    {
        if(start>end) return null;

        if(x<0) return null;
        TreeNode node = new TreeNode(pre.get(x--));

        if(start==end) return node;

        int mid = search(in, start, end, node.val);

        node.right = build(pre, in, mid+1, end);
        node.left = build(pre, in, start, mid-1);

        return node;
    }
    public static int search(ArrayList<Integer> x, int start, int end, int y)
    {
        int i;
        for(i=start;i<=end;i++) if(x.get(i)==y) return i;
        return i;
    }
}

