package greedy;
import java.util.*;
import java.io.*;
public class Bulbs
{
    public static int bulbs(ArrayList<Integer> a)
    {
        int i;
        int n = a.size();
        int c = 0;
        for(i=0;i<n;i++)
        {
            int cur = a.get(i);
            if(c%2==1) cur = 1-cur;
            if(cur==0)
            {
                c++;
            }
        }
        return c;
    }
}

