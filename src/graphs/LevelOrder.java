package graphs;
import java.util.*;
import java.io.*;

public class LevelOrder {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {

        TreeNode b = a;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(b==null) return ans;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(b);
        int s = 0;
        int level = 0;
        while (!queue.isEmpty())
        {
            ans.add(new ArrayList<>());
            s = queue.size();
            while(s-->0)
            {
                TreeNode node = queue.poll();
                ans.get(level).add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            level++;
        }

        return ans;

    }
}
