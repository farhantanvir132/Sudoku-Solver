import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static JFrame frame = new JFrame();
    public static JButton button[][] = new JButton[9][9];
    public static JLabel label = new JLabel();
    public static JButton solver = new JButton();

    public static boolean Solver(int board[][], int i, int j) {
        if (i == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;
        if (j != board.length-1) {
            nrow = i;
            ncol = j + 1;
        } else {
            nrow = i + 1;
            ncol = 0;
        }
        if (board[i][j] != 0) {
            if (Solver(board, nrow, ncol)) {
                return true;
            }
        } else {
            for (int p = 1; p <= 9; p++) {
                if (isSafe(board, i, j, p)) {
                    board[i][j] = p;
                    if (Solver(board, nrow, ncol)) {
                        return true;
                    }
                    else
                        {
                        board[i][j] = 0;
                        }
                }
            }
        }
        return false;

    }

    public static boolean isSafe(int board[][], int row, int col, int value) {

        for (int x = 0; x < 9; x++) {
            if (board[x][col] == value) {
                return false;
            }
            if (board[row][x] == value) {
                return false;
            }

        }
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }


            }
        }

        return true;

    }

    public static void solvesudoku(int[][] board) {

        Solver(board, 0, 0);
    }

    public static void display(int [][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                button[i][j].setText(String.valueOf(board[i][j]));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.green);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.yellow);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.yellow);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.green);
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.red);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.cyan);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.cyan);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.cyan);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.cyan);
            }
        }

        solver.setText("Solved");
        solver.setEnabled(false);


        System.out.println("SUDOKU SOLVED!");
    }

    public static void main(String[] args) {

       int adj[][] =  {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(799, 710);
        frame.setTitle("SUDOKU SOLVER");
        frame.setResizable(false);
        frame.setLayout(new GridLayout(10, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9; j++) {
                button[i][j] = new JButton();
               if (adj[i][j] != 0) {
                    button[i][j].setText(String.valueOf(adj[i][j]));

               } else if (adj[i][j] == 0) {
                    button[i][j].setText(" ");
                }
                button[i][j].setBounds(10, 10, 10, 10);
                button[i][j].setFont(new Font("Times New Roman", Font.BOLD, 29));
                button[i][j].setFocusable(false);
                button[i][j].setBorder(BorderFactory.createRaisedSoftBevelBorder());
                frame.add(button[i][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.red);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.yellow);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.red);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.green);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.cyan);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.green);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(Color.red);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                button[i][j].setBackground(Color.YELLOW);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                button[i][j].setBackground(Color.red);
            }
        }
        solver.setText("Solve");
        solver.setBounds(10, 10, 70, 40);
        solver.setFont(new Font("Times New Roman", Font.BOLD, 20));
        solver.setFocusable(false);
        solver.setBorder(BorderFactory.createEtchedBorder());
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.add(solver);
        frame.add(label);
        solvesudoku(adj);
        solver.addActionListener(e -> display(adj));
        frame.setVisible(true);
    }
}
/* Input 01:
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

     Output 01 -->
          3 1 6 5 7 8 4 9 2
          5 2 9 1 3 4 7 6 8
          4 8 7 6 2 9 5 3 1
          2 6 3 4 1 5 9 8 7
          9 7 4 8 6 3 1 2 5
          8 5 1 7 9 2 6 4 3
          1 3 8 9 4 7 2 5 6
          6 9 2 3 5 1 8 7 4
          7 4 5 2 8 6 3 1 9

   Input 02:
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};



       Output 02 -->
          5 3 4 6 7 8 9 1 2
          6 7 2 1 9 5 3 4 8
          1 9 8 3 4 2 5 6 7
          8 5 9 7 6 1 4 2 3
          4 2 6 8 5 3 7 9 1
          7 1 3 9 2 4 8 5 6
          9 6 1 5 3 7 2 8 4
          2 8 7 4 1 9 6 3 5
          3 4 5 2 8 6 1 7 9

 */

