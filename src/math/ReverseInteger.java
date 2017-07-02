package math;
import java.util.*;
import java.io.*;
public class ReverseInteger
{
    public int reverse(int a) {
        int x = Math.abs(a);
        long y = 0;
        while(x>0)
        {
            int d = x%10;
            y = y*10+d;
            x/=10;
        }
        if(y<Integer.MIN_VALUE || y>Integer.MAX_VALUE) y = 0;
        if(a<0) y = -y;
        return (int)y;
    }
}

