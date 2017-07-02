package trees;
import java.util.*;
import java.io.*;
public class VerticalOrderTraversalOfBinaryTree
{
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A==null) return ans;

        int i;
        int l = left(A), r = right(A);
        int n = l+r-1;
        for(i=0;i<n;i++) ans.add(new ArrayList<>());

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        TreeNode x = A;
        q.add(x);q2.add(l-1);

        while(!q.isEmpty())
        {
            x = q.poll();
            int y = q2.poll();

            ans.get(y).add(x.val);
            if(x.left!=null) {
                q.add(x.left); q2.add(y-1);
            }
            if(x.right!=null) {
                q.add(x.right); q2.add(y+1);
            }
        }
        i=0;
        while(i<ans.size())
        {
            if(ans.get(i).size()==0) ans.remove(i);
            else i++;
        }

        return ans;

    }
    public static int left(TreeNode A)
    {
        if(A==null) return 0;
        int x = 1+left(A.left);
        int y = left(A.right);
        return Math.max(x, y);
    }
    public static int right(TreeNode A)
    {
        if(A==null) return 0;
        int x = 1+right(A.right);
        int y = right(A.left);
        return Math.max(x, y);
    }
}
