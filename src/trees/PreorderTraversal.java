package trees;
import java.util.*;
import java.io.*;
public class PreorderTraversal
{
    public static ArrayList<Integer> preorderTraversal(TreeNode a)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null) return ans;

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = a;
        stack.push(cur);

        while(!stack.isEmpty())
        {
            cur = stack.pop();
            ans.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }

        return ans;

    }
}
