package trees;
import java.util.*;
import java.io.*;
public class PopulateNextRightPointersTree
{
    public static void connect(TreeLinkNode root)
    {
        if(root==null) return;

        TreeLinkNode a = root;

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(a);
        int size = 1;

        while(!queue.isEmpty())
        {
            size = queue.size()-1;

            while(size-->0)
            {
                TreeLinkNode x = queue.poll();
                x.next = queue.getFirst();
                if(x.left!=null) queue.add(x.left);
                if(x.right!=null) queue.add(x.right);
            }
            TreeLinkNode x = queue.poll();
            if(x!=null) x.next = null;
            if(x.left!=null) queue.add(x.left);
            if(x.right!=null) queue.add(x.right);
        }
    }
}
