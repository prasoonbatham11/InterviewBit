package graphs;
import java.util.*;
import java.io.*;

public class SteppingNumbers {
    static int n, m;
    static ArrayList<Integer> ans;
    static Graph g;
    static int a,b;
    public static ArrayList<Integer> stepnum(int A, int B)
    {
        a = A; b = B;
        n = (a+"").length();
        m = (b+"").length();

        ans = new ArrayList<>();
        g = new Graph(10);
        g.init();

        if(n==1)
        {
            for(int i=0;i<=9;i++) if(i>=a && i<=b) ans.add(i);
            n++;
        }
        if(n<=m)
            for(int i = 1;i<=9;i++)
            {
                bfs(i);
            }

        Collections.sort(ans);

        return ans;


    }

    public static void bfs(int node)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);queue.add(node);queue.add(1);
        while(!queue.isEmpty())
        {
            int x = queue.poll();
            int num = queue.poll();
            int len = queue.poll();
            if(len>m) break;
            if(len>=n && len<=m && num>=a && num<=b) ans.add(num);

            Iterator<Integer> i = g.adj[x].listIterator();
            while(i.hasNext())
            {
                int y = i.next();
                int newnum = num*10+y;
                queue.add(y); queue.add(newnum); queue.add(len+1);
            }
        }
    }

    public static class Graph
    {
        LinkedList<Integer> adj[];
        int n;
        public Graph(int v)
        {
            n = v;
            adj = new LinkedList[n];
            int i;
            for(i=0;i<v;i++)
                adj[i] = new LinkedList<Integer>();
        }
        public void addEdge(int a, int b)
        {
            adj[a].add(b);
            adj[b].add(a);
        }
        public void init()
        {
            for(int i=0;i<=8;i++)
            {
                addEdge(i, i+1);
            }
        }
    }

}


