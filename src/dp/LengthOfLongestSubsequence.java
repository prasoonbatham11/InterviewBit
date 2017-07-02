package dp;
import java.util.*;
import java.io.*;
public class LengthOfLongestSubsequence
{
    public int longestSubsequenceLength(final List<Integer> list)
    {
        int n = list.size();
        int i;
        int a[] = new int[n];
        int t[] = new int[n];
        int s[] = new int[n];

        for(i=0;i<n;i++) a[i] = list.get(i);

        Arrays.fill(t, 1);
        Arrays.fill(s, 1);

        int j;

        for(i=1;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i] && t[j]+1>t[i])
                    t[i] = t[j]+1;
            }
        }

        for(i=n-2;i>=0;i--)
        {
            for(j=n-1;j>i;j--)
            {
                if(a[j]<a[i] && s[j]+1>s[i])
                    s[i] = s[j]+1;
            }
        }

        int max = 0;
        for(i=0;i<n;i++) max = max>t[i]+s[i]?max:t[i]+s[i];

        return max-1>=0?max-1:0;
    }
}

