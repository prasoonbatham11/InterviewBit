package backtracking;
import java.util.*;
import java.io.*;
public class Permutations
{
    static ArrayList<ArrayList<Integer>> ans;
    static int[] a;
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> b)
    {
        int n = b.size();
        a=new int[n];
        int i;

        for(i=0;i<n;i++) a[i] = b.get(i);
        ans = new ArrayList<>();
        perm(0, n-1);
        return ans;

    }
    public static void perm(int l, int r)
    {
        if(l==r) {addtoans();return;}
        int i;
        for(i=l;i<=r;i++)
        {
            swap(i, l);
            //System.out.println(a);
            perm(l+1, r);
            swap(i, l);
        }
    }
    public static void addtoans()
    {
        ArrayList<Integer> x = new ArrayList<>();
        int i;
        int n = a.length;
        for(i=0;i<n;i++) x.add(a[i]);
        ans.add(x);
    }
    public static void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
