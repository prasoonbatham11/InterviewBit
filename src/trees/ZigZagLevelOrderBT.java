package trees;
import java.util.*;
import java.io.*;
public class ZigZagLevelOrderBT
{
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        int level = 1;
        boolean lr = false;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(a==null) return ans;

        ans.add(new ArrayList<>());
        ans.get(0).add(a.val);



        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        queue.add(a);

        while(!queue.isEmpty())
        {
            q2 = new LinkedList<>();
            ans.add(new ArrayList<>());
            while (!queue.isEmpty()) {
                TreeNode b = queue.poll();
                if(b.left!=null) q2.add(b.left);
                if(b.right!=null) q2.add(b.right);
            }

            int l = q2.size();
            int i;
            if(!lr)
                for(i=l-1;i>=0;i--) {
                    ans.get(level).add(q2.get(i).val);
                }
            else for(i=0;i<l;i++) ans.get(level).add(q2.get(i).val);

            lr = !lr;

            queue = q2;
            level++;

        }
        if(ans.get(ans.size()-1).size()==0) ans.remove(ans.size()-1);
        return ans;
    }
}
