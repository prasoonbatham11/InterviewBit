package bitmanipulation;
import java.util.*;
import java.io.*;
public class NumberOf1Bits
{
    public int numSetBits(long a) {
        int i;
        int count = 0;
        for(i=0;i<=32;i++)
        {
            if((a&(1L<<i))!=0) count++;
        }
        return count;
    }
}
