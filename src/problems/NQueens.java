package problems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> out = new ArrayList<String[]>();
        if (n <= 0)
            return out;

        int[] place = new int[n]; // record the queen location at each row.
        placeQueens(place, 0, out);
        return out;
    }
    
    void placeQueens(int[] place, int row, List<String[]> out) {
        for (int i = 0; i < place.length; i++) {
            place[row] = i;
            if (!check(place, row))
                continue;
            
            if (row == place.length - 1)
                printBoard(place, out);
            else
                placeQueens(place, row + 1, out);
        } 
    }
    
    boolean check(int[] place, int row) {
        for (int i = 0; i < row; i++) {
            if (place[i] == place[row])
                return false;
            if (Math.abs(place[i] - place[row]) == row - i)
                return false;
        }
        return true;
    }
    
    void printBoard(int[] place, List<String[]> out) {
        String[] board = new String[place.length];
        for (int i = 0; i < place.length; i++) {
            board[i] = "";
            for (int j = 0; j < place.length; j++) {
                if (j != place[i])
                    board[i] += '.';
                else
                    board[i] += 'Q';
            }
        }
        out.add(board);
    }
    
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        
        List<String[]> out = nq.solveNQueens(8);
        for (int i = 0; i < out.size(); i++) {
            for (int j = 0; j < out.get(i).length; j++)
                System.out.println(out.get(i)[j]);
            System.out.println();
        }
    }
}
