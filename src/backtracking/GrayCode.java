package backtracking;
import java.util.*;
import java.io.*;
public class GrayCode
{
    public static ArrayList<Integer> grayCode(int n)
    {
        return convert(gray(n),n);

    }
    public static ArrayList<String> gray(int n)
    {
        if(n==1) {
            ArrayList<String> x = new ArrayList<>();
            x.add("0"); x.add("1");
            return x;
        }
        ArrayList<String> l1 = gray(n-1);
        ArrayList<String> l2 = rev(l1);
        return merge(l1, l2);

    }

    public static ArrayList<Integer> convert(ArrayList<String> x, int n)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i;
        int m = x.size();
        for(i=0;i<m;i++)
        {
            String str = x.get(i);
            int c = 1;
            int z = 0;
            for(int j = n-1;j>=0;j--)
            {
                z+=(str.charAt(j)-'0')*c;
                c*=2;
            }
            ans.add(z);
        }
        return ans;
    }

    public static ArrayList<String> merge(ArrayList<String> x, ArrayList<String> y)
    {
        int n = x.size();
        int i;
        for(i=0;i<n;i++) x.set(i, "0"+x.get(i));
        for(i=0;i<n;i++) y.set(i, "1"+y.get(i));

        ArrayList<String> newArr = new ArrayList<>(x);
        for(i=0;i<n;i++) newArr.add(y.get(i));
        return newArr;
    }

    public static ArrayList<String> rev(ArrayList<String> x)
    {
        ArrayList<String> y = new ArrayList<>();
        int i;
        int n = x.size();
        for(i=n-1;i>=0;i--) y.add(x.get(i));
        return y;
    }

}
