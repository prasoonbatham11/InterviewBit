package dp;
import java.util.*;
import java.io.*;
public class EditDistance
{
    public static int minDistance(String a,String b)
    {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];

        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
                if(i==0) dp[i][j] = j;
                else if(j==0) dp[i][j] = i;
                else if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else
                {
                    dp[i][j] = 1+min(dp[i][j-1],
                            dp[i-1][j],
                            dp[i-1][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public static int min(int a, int b, int c)
    {
        return Math.min(a,Math.min(b,c));
    }
}
