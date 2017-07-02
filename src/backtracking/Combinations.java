package backtracking;
import java.util.*;
import java.io.*;
public class Combinations
{
    static ArrayList<ArrayList<Integer>> ans;
    static int n;
    static int k;
    static LinkedList<Integer> stack;
    public static ArrayList<ArrayList<Integer>> combine(int m, int l)
    {
        k = l;
        n = m;
        ans = new ArrayList<>();
        stack = new LinkedList<>();
        solve(n);
        Collections.sort(ans, new Compa());
        return ans;
    }
    public static void solve(int i)
    {
        if(i==0) {addtoans();return;}

        //System.out.println(i);

        solve(i-1);

        stack.push(i);
        solve(i-1);
        stack.pop();
    }
    public static void addtoans()
    {
        if(stack.size()!=k) return;
        Iterator<Integer> i = stack.listIterator();
        ArrayList<Integer> x = new ArrayList<>();
        while (i.hasNext())
        {
            x.add(i.next());
        }
        ans.add(x);
    }
}
class Compa implements Comparator<ArrayList<Integer>> {
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


