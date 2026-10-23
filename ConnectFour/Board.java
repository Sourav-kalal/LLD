public class Board {
    int ROW = 6;
    int COL = 7;
    Color[][] grid;
    State currentState;

    public Board() {
        grid = new Color[ROW][COL];
        currentState = State.IN_PROGRESS;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COL;
    }

    public boolean placeDisc(Player player, int column) {
        if (player == null || !canPlace(player, column)) {
            return false;
        }

        for (int row = ROW - 1; row >= 0; row--) {
            if (grid[row][column] == null) {
                grid[row][column] = player.getColor();
                return true;
            }
        }
        return false;
    }

    public boolean canPlace(Player player, int column) {
        return player != null && isInBound(0, column) && grid[0][column] == null;
    }

    public boolean canWin(Player player, int row, int column) {
        if (player == null || !isInBound(row, column)
                || grid[row][column] != player.getColor()) {
            return false;
        }

        int[][] directions = {
            {0, 1}, {1, 0}, {1, 1}, {1, -1}
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
        for (int column = 0; column < COL; column++) {
            if (grid[0][column] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isInBound(int row, int column) {
        return row >= 0 && row < ROW && column >= 0 && column < COL;
    }
}
