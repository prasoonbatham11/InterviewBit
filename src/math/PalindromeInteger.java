package math;
import java.util.*;
import java.io.*;
public class PalindromeInteger
{
    public boolean isPalindrome(int a) {
        String x = a+"";
        int len = x.length();
        int i;
        for(i=0;i<len;i++) if(x.charAt(i)!=x.charAt(len-i-1)) return false;
        return true;
    }
}

