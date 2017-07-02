package math;
import java.util.*;
import java.io.*;
public class ExcelColumnNumber
{
    public int titleToNumber(String a) {
        int count = 0;
        int i;
        int len = a.length();
        int x = len-1;
        int y = 1;
        for(i=x;i>=0;i--)
        {
            count += (a.charAt(i)-'A'+1)*y;
            y *= 26;
        }

        return count;


    }
}

