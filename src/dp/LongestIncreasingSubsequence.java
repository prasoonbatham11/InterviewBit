package dp;
import java.util.*;
import java.io.*;
public class LongestIncreasingSubsequence
{
    public static int lis(final List<Integer> list)
    {
        int n = list.size();
        int t[] = new int[n];
        Arrays.fill(t, 1);
        int a[] = new int[n];
        int i;
        for(i=0;i<n;i++) a[i] = list.get(i);

        int j;
        for(i=1;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i] && t[j]+1>t[i])
                    t[i] = t[j]+1;
            }
        }

        int max = 1;
        for(i=0;i<n;i++) max = max>t[i]?max:t[i];
        return max;
    }
}
