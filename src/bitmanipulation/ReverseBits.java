package bitmanipulation;
import java.util.*;
import java.io.*;
public class ReverseBits
{
    public static long reverse(long a) {
        long n = a;
        StringBuilder s = new StringBuilder();

        while(n>0)
        {
            s.append(n%2);
            n/=2;
        }

        int l = s.length();

        int i;
        for(i=l;i<=32;i++) s.append('0');

        String str = s.toString();

        long mul = 1;
        long ans = 0;
        for(i=31;i>=0;i--)
        {
            ans += (str.charAt(i)-'0')*mul;
            mul *= 2;
        }
        return ans;
    }
}

