
enum GameState {
    IN_PROGRESS,
    WON,
    DRAW
}

enum Color {
    RED,
    BLUE
}

class Player {
    private final String name;
    private final Color color;
}

class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;

    private final Color[][] grid;

    public boolean isValidMove(int column);
    public int getAvailableRow(int column);
    public void placeDisc(Color color, int row, int column);
    public boolean isFull();
}

class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;
    private Player winner;
    private GameState state;

    public boolean makeMove(Player player, int column);
    private void switchPlayer();
    private boolean checkWinner(int row, int column);
    private void checkGameOver(int row, int column);

    public Board getBoard();
    public Player getCurrentPlayer();
    public GameState getState();
    public Player getWinner();
}
