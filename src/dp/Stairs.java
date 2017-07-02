package dp;
import java.util.*;
import java.io.*;
public class Stairs
{
    public int climbStairs(int n) {

        if(n==0 || n==1) return 1;
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 1;

        int i;
        for(i=2;i<=n;i++)
        {
            a[i] = a[i-1]+a[i-2];
        }

        return a[n];
    }
}
