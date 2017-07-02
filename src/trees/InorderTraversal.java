package trees;
import java.util.*;
import java.io.*;
public class InorderTraversal
{
    public static ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null) return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = a;

        do {
            while(cur!=null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()) {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }while (!stack.isEmpty() || cur!=null);

        return ans;
    }
}

