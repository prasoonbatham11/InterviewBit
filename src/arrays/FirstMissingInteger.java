package arrays;
import java.util.*;
import java.io.*;
public class FirstMissingInteger
{
    public int firstMissingPositive(ArrayList<Integer> a) {
        int n = a.size();

        int i=0;
        while(i<n)
        {
            int x = a.get(i);
            if(x>=1 && x<=n && x!=i+1 && x!=a.get(x-1))
            {
                a.set(i, a.get(x-1));
                a.set(x-1, x);
            }
            else i++;
        }

        for(i=0;i<n;i++) if(a.get(i)!=i+1) return i+1;
        return n+1;
    }
}
