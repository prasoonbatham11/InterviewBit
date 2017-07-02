package backtracking;
import java.util.*;
import java.io.*;
public class Sudoku
{
    static int board[][];
    public static void solveSudoku(ArrayList<ArrayList<Character>> a)
    {
        board = new int[9][9];
        int i,j;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(a.get(i).get(j)=='.') board[i][j] = 0;
                else
                    board[i][j] = a.get(i).get(j)-'0';
            }
        }
        solve();

        for(i=0;i<9;i++) for(j=0;j<9;j++) a.get(i).set(j, (char)(board[i][j]+'0'));

    }
    public static boolean solve()
    {
        Pair y = findNext();
        if(y.f==-1) return true;

        int row = y.f, col = y.s;

        for(int x = 1;x<=9;x++)
        {

            if(isSafe(row, col, x)) {
                board[row][col] = x;
                if(solve()) return true;
                board[row][col]= 0;
            }
        }
        return false;
    }

    public static Pair findNext()
    {
        int i,j;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(board[i][j] == 0)
                    return new Pair(i, j);
            }
        }
        return new Pair(-1, -1);
    }
    public static boolean isSafe(int i, int j, int n)
    {
        int x, y;
        for(x=0;x<9;x++) if(board[x][j]==n) return false;
        for(y=0;y<9;y++) if(board[i][y]==n) return false;
        x = (i/3)*3;
        y = (j/3)*3;
        for(int k = x;k<x+3;k++)
        {
            for(int l = y;l<y+3;l++) {
                if(board[k][l]==n) return false;
            }
        }
        return true;
    }
}
class Pair {
    int f, s;
    Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
    Pair()
    {
        this(0,0);
    }
}
