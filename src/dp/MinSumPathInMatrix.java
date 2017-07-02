package dp;
import java.util.*;
import java.io.*;
public class MinSumPathInMatrix
{
    public static int minPathSum(ArrayList<ArrayList<Integer>> a)
    {
        int i,j;
        int m = a.size();
        int n = a.get(0).size();

        int dp[][] = new int[m][n];
        dp[0][0] = a.get(0).get(0);

        for(i=1;i<m;i++) dp[i][0] = dp[i-1][0]+a.get(i).get(0);

        for(j=1;j<n;j++) dp[0][j] = dp[0][j-1]+a.get(0).get(j);

        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                dp[i][j] = a.get(i).get(j)+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
