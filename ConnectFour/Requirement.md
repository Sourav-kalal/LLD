# Connect Four — Requirements

1. **Board:** The game uses a 7-column × 6-row grid. When a player places a disc in a column, it falls to the lowest available row.
2. **Players and colors:** Each player can place discs of one fixed color.
3. **Win and draw conditions:**
   - A player wins by aligning discs of their color horizontally, vertically, or diagonally.
   - If the board is full and no player has won, the game is a draw.
4. **Turn and game scope:** Only one move is made at a time. Undo and redo are not supported. The game is a single game and does not support concurrent play.
5. **After a win:** Once a player wins, no further moves are allowed.
