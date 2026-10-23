# Connect Four — Class Design

## 1. Design Overview
Keep game rules in `Game`, grid storage and gravity in `Board`, and winning-pattern detection in `WinChecker`.

## 2. Types

### `Color` (enum)
- `RED`
- `BLUE`

### `GameState` (enum)
- `IN_PROGRESS`
- `WON`
- `DRAW`

### `MoveResult` (enum)
- `SUCCESS`
- `INVALID_COLUMN`
- `COLUMN_FULL`
- `NOT_CURRENT_PLAYER`
- `GAME_OVER`
- `INVALID_PLAYER`

### `Player`
**Fields**
- `name: String`
- `color: Color`

**Responsibilities**
- Represents one player.
- Name and color are immutable after construction.

### `Board`
**Fields**
- `ROWS: int = 6`
- `COLUMNS: int = 7`
- `cells: Color[ROWS][COLUMNS]`

A `null` cell represents an empty cell.

**Methods**
- `boolean canPlace(int column)`
- `int getAvailableRow(int column)` — returns the lowest empty row, or `-1` if full.
- `void placeDisc(int row, int column, Color color)`
- `Color getCell(int row, int column)`
- `boolean isFull()`

**Responsibilities**
- Owns the grid.
- Finds the landing row for a column and places discs.
- Does not decide whose turn it is or whether the game is won.

**Indexing**
- Use zero-based indices.
- Row `0` is the top; row `5` is the bottom.
- Search for a landing row from row `5` upwards.

### `WinChecker`
**Methods**
- `boolean hasWon(Board board, int row, int column, Color color)`

**Responsibilities**
- Checks for a winning line passing through the most recently placed disc.
- Checks four axes: horizontal `(0, 1)`, vertical `(1, 0)`, diagonal `(1, 1)`, and diagonal `(1, -1)`.
- For each axis, count matching discs in both directions from the last disc, including the last disc. Four or more means a win.

### `Game`
**Fields**
- `board: Board`
- `playerOne: Player`
- `playerTwo: Player`
- `currentPlayer: Player`
- `state: GameState`
- `winner: Player | null`
- `winChecker: WinChecker`

**Methods**
- `MoveResult makeMove(Player player, int column)`
- `Board getBoard()`
- `Player getCurrentPlayer()`
- `GameState getState()`
- `Player getWinner()`

**Responsibilities**
- Validates game state, player identity, turn, and column.
- Coordinates disc placement and win/draw detection.
- Changes the current player only after a successful move that does not end the game.

## 3. Move Flow
1. If the game is not `IN_PROGRESS`, return `GAME_OVER`.
2. If the supplied player is not one of this game's two players, return `INVALID_PLAYER`.
3. If the supplied player is not the current player, return `NOT_CURRENT_PLAYER`.
4. If the column is outside `0..6`, return `INVALID_COLUMN`.
5. If the column has no available row, return `COLUMN_FULL`.
6. Find the landing row and place the player's disc.
7. Check whether that placement wins. If so, set `winner`, set state to `WON`, and return `SUCCESS`.
8. Otherwise, if the board is full, set state to `DRAW` and return `SUCCESS`.
9. Otherwise switch the current player and return `SUCCESS`.

## 4. Invariants
- The game always has exactly two players with distinct colors.
- A cell contains at most one disc.
- Discs in a column occupy cells from the bottom upwards without gaps.
- Only the current player may make a valid move.
- `winner` is non-null only when state is `WON`.
- No moves are accepted once state is `WON` or `DRAW`.

## 5. Complexity
- A move's placement is `O(ROWS)` in the worst case when finding a landing row.
- Win detection is `O(ROWS + COLUMNS)` with directional counting bounded by the board dimensions.
- Board storage is `O(ROWS × COLUMNS)`.
