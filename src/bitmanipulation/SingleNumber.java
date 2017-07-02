package bitmanipulation;
import java.util.*;
import java.io.*;
public class SingleNumber
{
    public int singleNumber(final List<Integer> a) {
        Iterator<Integer> i = a.listIterator();
        int xor = 0;
        while(i.hasNext())
        {
            int x = i.next();
            xor = xor^x;
        }
        return xor;
    }
}

