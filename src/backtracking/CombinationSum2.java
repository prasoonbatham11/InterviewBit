package backtracking;
import java.util.*;
import java.io.*;
public class CombinationSum2
{
    static int n;
    static LinkedList<Integer> stack;
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<Integer> x;
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        n = a.size();
        stack = new LinkedList<>();
        x = new ArrayList<>(a);

        ans = new ArrayList<>();

        coin(n-1, b);

        Collections.sort(ans, new Compc());

        ArrayList<ArrayList<Integer>> xx = new ArrayList<>();
        int m = ans.size();
        int i;
        if(m==0) return xx;
        xx.add(ans.get(0));
        for(i=1;i<m;i++) if(!ans.get(i).equals(ans.get(i-1))) xx.add(ans.get(i));

        return xx;


    }
    public static void coin(int i, int sum)
    {
        if(sum==0) {addtosum();return;}
        if(i<0) return;

        if(sum-x.get(i)>=0) {
            stack.push(x.get(i));
            coin(i-1, sum-x.get(i));
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
class Compc implements Comparator<ArrayList<Integer>> {
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