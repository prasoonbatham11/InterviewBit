package dp;
import java.util.*;
import java.io.*;
public class CoinSumInfinite
{
    static int a[], dp[][];
    static int MOD = 1000007;

    public int coinchange2(ArrayList<Integer> list, int b) {
        int n = list.size();
        a = new int[n+1];
        int i;
        for(i=1;i<=n;i++) a[i] = list.get(i-1);
        //dp = new int[b+1][n+1];

        int table[] = new int[b+1];
        table[0] = 1;

        int j;

        for(i=1;i<=n;i++) {
            for(j=a[i];j<=b;j++)
            {
                table[j] = (table[j]+table[j-a[i]])%MOD;
            }
        }

        return table[b];
    }
    public int coin(int b, int i)
    {
        if(b<0) return 0;
        if(b==0) return 1;
        if(i==a.length && b>0) return 0;

        if(dp[b][i]!=-1) return dp[b][i];

        return dp[b][i] = (coin(b, i+1) + coin(b-a[i], i))%MOD;
    }
}