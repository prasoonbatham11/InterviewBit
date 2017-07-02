package backtracking;
import java.util.*;
import java.io.*;
public class LetterPhone
{
    static ArrayList<ArrayList<Character>> a;
    static int n;
    static String s;
    static ArrayList<String> ans;
    static LinkedList<Character> stack;

    public static ArrayList<String> letterCombinations(String str) {
        a = new ArrayList<>();
        ans = new ArrayList<>();
        stack = new LinkedList<>();
        init();
        s = str;
        n = s.length();
        solve(0);
        Collections.sort(ans);
        return ans;
    }
    public static void solve(int i)
    {
        if(i==n) {addtoans();return;}

        int x = s.charAt(i)-'0';
        int len = a.get(x).size();
        for(int j = 0; j<len;j++)
        {
            stack.push(a.get(x).get(j));
            solve(i+1);
            stack.pop();
        }
    }
    public static void addtoans()
    {
        String x = "";
        Iterator<Character> i = stack.listIterator();
        while(i.hasNext()) {
            x = i.next()+x;
        }
        ans.add(x);
    }
    public static void init()
    {
        for(int i=0;i<=9;i++) a.add(new ArrayList<>());

        a.get(0).add('0');
        a.get(1).add('1');

        char c = 'a';
        for(int i=2;i<=7;i++)
        {
            a.get(i).add(c);
            a.get(i).add((char)(c+1));
            a.get(i).add((char)(c+2));
            c+=3;
        }
        a.get(7).add('s');

        a.get(8).add('t');
        a.get(8).add('u');
        a.get(8).add('v');
        for(char x = 'w';x<='z';x++)
        {
            a.get(9).add(x);
        }
    }
}
