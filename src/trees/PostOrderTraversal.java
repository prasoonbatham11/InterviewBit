package trees;
import java.util.*;
import java.io.*;
public class PostOrderTraversal
{
    public static ArrayList<Integer> postorderTraversal(TreeNode a)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null) return ans;

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = a;
        stack.push(cur);

        while(!stack.isEmpty())
        {
            TreeNode x = stack.peek();

            boolean subt = x.left == cur || x.right == cur;
            boolean isLeaf = x.left==null && x.right==null;

            if(subt||isLeaf)
            {
                stack.pop();
                ans.add(x.val);
                cur = x;
            }
            else
            {
                if(x.right!=null) stack.push(x.right);
                if(x.left!=null) stack.push(x.left);
            }
        }

        return ans;
    }
}
