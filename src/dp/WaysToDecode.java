package dp;
import java.util.*;
import java.io.*;
public class WaysToDecode
{
    public static int numDecodings(String a) {

        a = "0"+a;

        int n = a.length();
        int dp[] = new int[n];

        dp[0] = 1;
        if(a.charAt(1)!='0')
            dp[1] = 1;

        int i;
        for(i=2;i<n;i++)
        {
            if(a.charAt(i)!='0') dp[i] = dp[i-1];
            int num = (a.charAt(i-1)-'0')*10 + (a.charAt(i)-'0');
            //System.out.println(num);
            if(num>=10 && num<=26) dp[i]+=dp[i-2];
        }
        //System.out.println(Arrays.toString(dp));

        return dp[n-1];


    }
}