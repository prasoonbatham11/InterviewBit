package strings;
import java.util.*;
import java.io.*;
public class  LengthOfLastWord
{
    public int lengthOfLastWord(final String a) {
        boolean space = true;
        int i;
        int n = a.length();
        for(i=0;i<n;i++) if(a.charAt(i)!=' ') space = false;

        if(space) return 0;

        String temp[] = a.split(" ");
        return temp[temp.length-1].length();
    }
}
