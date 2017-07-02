package stacksandqueues;
import java.util.*;
import java.io.*;
public class RedundantBraces
{
    public static int braces(String a)
    {
        LinkedList<Character> brace = new LinkedList<>();

        int i;
        int n = a.length();
        for(i=0;i<n;i++)
        {
            char c = a.charAt(i);

            if(c==')')
            {
                int cnt = 0;
                while(true)
                {
                    char x = brace.pop();
                    if(x=='(') break;
                    cnt++;
                }
                if(cnt<=1) return 1;
            }
            else brace.push(c);

        }
        return 0;
    }
}
