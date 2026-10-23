# Connect Four — Requirements

## 1. Overview
Connect Four is a two-player, turn-based board game. Players take turns dropping colored discs into a vertical grid. The first player to connect four or more of their discs in a straight line wins.

## 2. Functional Requirements
1. The board has 6 rows and 7 columns.
2. Exactly two players participate in a game.
3. Each player is assigned one distinct color: RED or BLUE. A player's color does not change during the game.
4. Players alternate turns, starting with the configured starting player.
5. On a move, a player selects a column. The disc falls to the lowest unoccupied cell in that column.
6. A move is valid only if the game is in progress, it is the current player's turn, the column index is valid, and the column is not full.
7. Invalid moves must not change the board, current player, winner, or game state.
8. A player wins when they connect at least four of their own discs horizontally, vertically, or diagonally in either direction.
9. After each valid move, check for a win before checking whether the board is full.
10. If the board is full and there is no winner, the game ends in a draw.
11. No further moves are accepted after a win or draw.

## 3. Game States
- IN_PROGRESS — moves are allowed.
- WON — a player has won; no more moves are allowed.
- DRAW — the board is full and no player has won; no more moves are allowed.

## 4. Out of Scope
- Graphical or web UI
- AI/computer opponent
- Networking or online multiplayer
- Undo/redo
- Concurrent moves or thread-safety
- Persistence, accounts, and match history

## 5. Acceptance Criteria
- A disc lands in the lowest empty cell of the selected column.
- A move in an invalid or full column is rejected without changing state.
- Only the current player can make a valid move.
- Horizontal, vertical, and both diagonal connections of four are detected.
- A win takes precedence over a full-board draw check.
- A full board with no winning connection ends in a draw.
- Moves after the game ends are rejected.
