package backtracking;
import java.util.*;
import java.io.*;
public class Subset
{
    static ArrayList<ArrayList<Integer>> ans;
    static int n;
    static int set[];
    static LinkedList<Integer> stack;
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a)
    {
        n = a.size();
        set = new int[n+1];
        int i;
        for(i=1;i<=n;i++) set[i] = a.get(i-1);
        mergeSort(set, 1, n);

        stack = new LinkedList<>();
        ans = new ArrayList<>();

        solve(n);

        Collections.sort(ans, new Comp());

        return ans;


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
class Comp implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        int n = a.size(), m = b.size();
        int i=0;
        while (true)
        {
            if(i==n) return -1;
            if(i==m) return 1;
            if(a.get(i)!=b.get(i)) return a.get(i)-b.get(i);
            i++;
        }
    }
}
