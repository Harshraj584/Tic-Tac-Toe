# Tic-Tac-Toe

This project is a Tic-Tac-Toe game built in Java using Swing for the graphical user interface. It supports two-player mode, automatic win detection, and a restart option so players can play multiple rounds.

Tic-Tac-Toe is a classic strategy game where two players take turns placing their marks (X or O) on a 3x3 grid. The first player to align three of their marks horizontally, vertically, or diagonally wins the game. If all cells are filled and no player has won, the game ends in a draw.

# Features
✅ Graphical User Interface (GUI) using Java Swing

✅ 2D array-based logic for managing game moves

✅ Win detection for rows, columns, and diagonals

✅ Restart functionality to play multiple rounds

✅ Input validation to prevent selecting occupied cells

✅ JOptionPane pop-ups for game results and restart prompt

# 🎮 How to Play
- The game starts with Player 'X'.

- Players take turns clicking on empty buttons to place their mark (X or O).

- The game checks for a win condition (three in a row, column, or diagonal).

- If the board is full and no player has won, it's a draw.

- A popup window announces the result (Win/Loss/Draw).

- Players can restart the game or exit when the match ends.

# 📝 Code Explanation

## 1️⃣ Game Board & Data Structure
- The game board is represented using a 3x3 2D array (char[][] board).

- The board initializes with empty (-) spaces.

- Players (X and O) take turns making moves.

## 2️⃣ Win Detection Logic
The game checks if a player has won by verifying:

- **Rows** → Three of the same marks (X or O) in a row.

- **Columns** → Three of the same marks in a column.

- **Diagonals** → Three of the same marks diagonally.

If any of the above conditions are met, the game declares a winner.

## 3️⃣ Graphical User Interface (GUI)
- The interface is built using Swing (JButton, JPanel, GridLayout).

- The Tic-Tac-Toe board consists of 3x3 buttons.

- Buttons update dynamically when a player makes a move.

- JOptionPane pop-ups display the game results.

## 4️⃣ Restart & Exit Functionality
After a game ends, a popup asks the user:
_"Do you want to play again?"_

- **YES** → The game resets the board and starts a new round.
- **NO** → The game closes.

