package graphs;
import java.util.*;
import java.io.*;
public class SumOfFibonacciNumbers
{
    public static int lowerBound(int a[], int n, int x)
    {
        int l = 0;
        int h = n;
        while(l<h)
        {
            int m = (l+h)/2;
            if(x<=a[m]) h = m;
            else l = m+1;
        }
        return l;
    }
    public static int fibsum(int a)
    {
        int fib[] = new int[46];
        int i;
        fib[0] = 1; fib[1] = 1;
        for(i=2;i<fib.length;i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }

        //System.out.println(Arrays.toString(fib));

        int count = 0;
        while (a>0)
        {
            int x = lowerBound(fib, 46, a);
            if(fib[x]>a) x--;
            //System.out.println("lower"+fib[x]);
            a = a-fib[x];
            count++;
        }

        return count;
    }
}
