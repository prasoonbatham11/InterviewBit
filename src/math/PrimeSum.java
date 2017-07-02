package math;
import java.util.*;
import java.io.*;
public class PrimeSum
{
    public static ArrayList<Integer> primesum(int a)
    {
        boolean seive[] = new boolean[a+1];Arrays.fill(seive,true);
        seive[0] = seive[1] = false;
        int p,j;
        for(p=2;p*p<seive.length;p++) if(seive[p]) for(j=p*p;j<seive.length;j+=p) seive[j] = false;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 2;i<seive.length;i++)
        {
            if(seive[i])
            {
                if(seive[a-i])
                {
                    ans.add(i);
                    ans.add(a-i);
                    break;
                }
            }
        }
        return ans;
    }
}
