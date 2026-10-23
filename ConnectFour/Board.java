import java.util.Arrays;

public class Board {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;

    // null means the cell is empty.
    private final Color[][] grid = new Color[ROWS][COLUMNS];

    public int getRow() {
        return ROWS;
    }

    public int getColumn() {
        return COLUMNS;
    }

    public Color getCell(int row, int column) {
        if (!isInBound(row, column)) {
            throw new IndexOutOfBoundsException("Cell is outside the board.");
        }
        return grid[row][column];
    }

    public boolean isInBound(int row, int column) {
        return row >= 0 && row < ROWS && column >= 0 && column < COLUMNS;
    }

    public boolean canPlace(int column) {
        return column >= 0 && column < COLUMNS && grid[0][column] == null;
    }

    /**
     * Drops a player's disc into the requested column.
     * Returns the row where it landed, or -1 if the column is invalid/full.
     */
    public int placeDisc(Player player, int column) {
        if (player == null || !canPlace(column)) {
            return -1;
        }

        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][column] == null) {
                grid[row][column] = player.getColor();
                return row;
            }
        }
        return -1;
    }

    public boolean canWin(Player player, int row, int column) {
        if (player == null || !isInBound(row, column)
                || grid[row][column] != player.getColor()) {
            return false;
        }

        int[][] directions = {
            {0, 1},   // horizontal
            {1, 0},   // vertical
            {1, 1},   // diagonal down-right / up-left
            {1, -1}   // diagonal down-left / up-right
        };

        for (int[] direction : directions) {
            int count = 1;
            count += countDirection(row, column, direction[0], direction[1], player.getColor());
            count += countDirection(row, column, -direction[0], -direction[1], player.getColor());
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    private int countDirection(int row, int column, int rowStep, int columnStep, Color color) {
        int count = 0;
        int r = row + rowStep;
        int c = column + columnStep;

        while (isInBound(r, c) && grid[r][c] == color) {
            count++;
            r += rowStep;
            c += columnStep;
        }
        return count;
    }

    public boolean isFull() {
        for (Color[] row : grid) {
            for (Color cell : row) {
                if (cell == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (Color[] row : grid) {
            System.out.print("|");
            for (Color cell : row) {
                System.out.print((cell == null ? " " : cell == Color.RED ? "R" : "B") + "|");
            }
            System.out.println();
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }
}
