package math;
import java.util.*;
import java.io.*;
public class TrailingZeroesInFactorial
{
    public int trailingZeroes(int a) {
        int x = 5;
        int count = 0;
        while(a/x>0)
        {
            count+=a/x;
            x = x*5;
        }
        return count;
    }
}
