package backtracking;
import java.util.*;
import java.io.*;
public class CombinationSum
{
    static int n;
    static LinkedList<Integer> stack;
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<Integer> x;
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        n = a.size();
        stack = new LinkedList<>();
        x = new ArrayList<>();
        int i;
        x.add(a.get(0));
        for(i=1;i<n;i++) if(a.get(i)!=a.get(i-1)) x.add(a.get(i));
        n = x.size();
        ans = new ArrayList<>();

        coin(n-1, b);

        Collections.sort(ans, new Compb());

        return ans;


    }
    public static void coin(int i, int sum)
    {
        if(sum==0) {addtosum();return;}
        if(i<0) return;

        if(sum-x.get(i)>=0) {
            stack.push(x.get(i));
            coin(i, sum-x.get(i));
            stack.pop();
        }
        coin(i-1, sum);
    }
    public static void addtosum()
    {
        Iterator<Integer> i = stack.listIterator();
        ArrayList<Integer> y = new ArrayList<>();
        while (i.hasNext())
        {
            y.add(i.next());
        }
        ans.add(y);
    }

}
class Compb implements Comparator<ArrayList<Integer>> {
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



