package strings;
import java.util.*;
import java.io.*;
public class PalindromeString
{
    public int isPalindrome(String a) {
        StringBuilder s = new StringBuilder();
        int n = a.length();
        int i;
        for(i=0;i<n;i++)
        {
            char c = a.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
                s.append(c);
        }

        String str = s.toString();
        n = str.length();
        str = str.toLowerCase();
        for(i=0;i<n;i++)
        {
            if(str.charAt(i)!=str.charAt(n-1-i)) return 0;
        }
        return 1;
    }
}

