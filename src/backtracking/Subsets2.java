package backtracking;
import java.util.*;
import java.io.*;
public class Subsets2
{
    static ArrayList<ArrayList<Integer>> ans;
    static int n;
    static int set[];
    static LinkedList<Integer> stack;
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a)
    {
        n = a.size();
        set = new int[n+1];
        int i;
        for(i=1;i<=n;i++) set[i] = a.get(i-1);
        mergeSort(set, 1, n);

        stack = new LinkedList<>();
        ans = new ArrayList<>();

        solve(n);

        Collections.sort(ans, new Compd());

        n = ans.size();
        ArrayList<ArrayList<Integer>> xx = new ArrayList<>();
        if(n==0) return ans;
        xx.add(ans.get(0));
        for(i=1;i<n;i++) if(!ans.get(i).equals(ans.get(i-1))) xx.add(ans.get(i));

        return xx;


    }
    public static void solve(int i)
    {
        if(i==0) {addtoans();return;}

        //System.out.println(i);

        solve(i-1);

        stack.push(set[i]);
        solve(i-1);
        stack.pop();
    }
    public static void addtoans()
    {
        //System.out.println(stack);
        Iterator<Integer> i = stack.listIterator();
        ArrayList<Integer> x = new ArrayList<>();
        while (i.hasNext())
        {
            x.add(i.next());
        }
        ans.add(x);
    }
    public static void mergeSort(int a[],int left,int right)
    {
        int mid=(left+right)/2;
        if(left<right)
        {
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
    public static void merge(int a[],int left,int mid,int right)
    {
        int t[]=new int[right-left+1];
        int pos=0,lpos=left,rpos=mid+1;
        while(lpos<=mid&&rpos<=right)
        {
            if(a[lpos]<a[rpos])
                t[pos++]=a[lpos++];
            else
                t[pos++]=a[rpos++];
        }
        while(lpos<=mid) t[pos++]=a[lpos++];
        while(rpos<=right) t[pos++]=a[rpos++];
        while(--pos>=0) a[pos+left]=t[pos];
    }
}
class Compd implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        int an = a.size();
        int bn = b.size();
        for(int i=0;i<Math.min(an,bn);i++)
        {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if(cmp!=0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}

