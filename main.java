import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        initializeBoard();
        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
                board[i][j] = '-';
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j] && board[i][j] == '-') {
                    board[i][j] = currentPlayer;
                    buttons[i][j].setText(String.valueOf(currentPlayer));
                    if (checkWin(currentPlayer)) {
                        JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                        gameOver = true;
                        restartGame();
                    } else if (isBoardFull()) {
                        JOptionPane.showMessageDialog(this, "It's a draw!");
                        gameOver = true;
                        restartGame();
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                    return;
                }
            }
        }
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void restartGame() {
        int response = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            gameOver = false;
            currentPlayer = 'X';
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                    buttons[i][j].setText("");
                }
            }
        } else {
            dispose(); // Close the window if the user chooses "No"
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGame());
    }
}
