package arrays;
import java.util.*;
import java.io.*;
public class MaxSumContiguousSubarray
{
    public int maxSubArray(final List<Integer> a)
    {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        Iterator<Integer> i = a.listIterator();

        while(i.hasNext())
        {
            int x = i.next();
            sum+=x;
            max = max>sum?max:sum;
            if(sum<0) sum = 0;
        }
        return max;
    }
}
