package arrays;
import java.util.*;
import java.io.*;
public class MaxNonNegativeSubArray
{
    public ArrayList<Integer> maxset(final ArrayList<Integer> arrayList)
    {
        int n = arrayList.size();
        int i;
        int a[] = new int[n+1];
        a[n] = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(i=0;i<n;i++) {
            a[i] = arrayList.get(i);
            max = max>a[i]?max:a[i];
        }

        if(max<0) {ArrayList<Integer> x = new ArrayList<>();return x;}

        i = 0;
        n++;

        long sum = 0;
        int len = 0;
        int start = 0;

        long maxsum = 0;
        int maxlen = 0;
        int minstart = Integer.MAX_VALUE;

        while(i<n)
        {
            if(a[i]<0)
            {
                start = start - len + 1;
                //System.out.println(start+" "+len+" "+sum);
                //System.out.println("before"+minstart+" "+maxlen+" "+maxsum);

                if(maxsum<sum)
                {
                    maxsum = sum;
                    maxlen = len;
                    minstart = start;
                }
                else if(maxsum==sum)
                {
                    if(maxlen<len) {maxlen = len;minstart = start;}
                    else if(maxlen==len)
                    {
                        if(minstart>start) {minstart = start;}
                    }
                }
                //System.out.println("after"+minstart+" "+maxlen+" "+maxsum);

                sum = 0;
                len = 0;
                start = 0;
            }
            else
            {
                sum+=a[i];
                len++;
                start = i;
            }
            i++;
        }

        //System.out.println(minstart+" "+maxlen+" "+maxsum);

        ArrayList<Integer> ans = new ArrayList<>();

        for(i=minstart; i<minstart+maxlen;i++)
        {
            ans.add(a[i]);
        }

        return ans;


    }
}
