package arrays;
import java.util.*;
import java.io.*;
public class RepeatAndMissingNumberArray
{
    public  ArrayList<Integer> repeatedNumber(final List<Integer> a) {


        int i=0;
        int n = a.size();
        int A = 0, B = 0;

        long m = n;
        long S = 0, T = 0, U = 0, V = 0;

        for(i=0;i<n;i++)
        {
            S+= (long) (i+1);
            U+= ((long)(i+1)) * (long)(i+1);

            long x = a.get(i);

            T+= x;
            V+= x*x;
        }

        long Y = T-S;
        long Z = V-U;

        Z = Z/Y;

        A = (int)((Z+Y)/2);
        B = A-(int)Y;


        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A); ans.add(B);
        return ans;



    }
}
