package stacksandqueues;
import java.util.*;
import java.io.*;
public class SimplifyDirectoryPath
{
    public static String simplifyPath(String a)
    {
        String temp[] = a.split("/");

        int n = temp.length;
        LinkedList<String> stack = new LinkedList<>();

        String t[] = new String[n];
        int j, k = 0;
        for(j=0;j<n;j++)
        {
            if(!temp[j].equals("")) t[k++] = temp[j];
        }

        //System.out.println(Arrays.toString(temp));
        int i;
        for(i=0;i<k;i++)
        {
            //System.out.println(stack);
            if(t[i].equals(".")) continue;
            else if(t[i].equals("..")) {if(!stack.isEmpty()) stack.pop();}
            else stack.push(t[i]);
        }
        StringBuilder str = new StringBuilder();

        LinkedList<String> st = new LinkedList<>();

        while(!stack.isEmpty())
        {
            st.push(stack.pop());
        }
        //System.out.println(st);

        while(!st.isEmpty())
        {
            str.append("/").append(st.pop());
        }

        String s = str.toString();
        if(s.equals("")) s = "/";
        return s;

    }
}
