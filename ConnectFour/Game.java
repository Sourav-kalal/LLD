import java.util.Objects;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private State state;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = Objects.requireNonNull(player1, "Player 1 cannot be null.");
        this.player2 = Objects.requireNonNull(player2, "Player 2 cannot be null.");

        if (player1 == player2) {
            throw new IllegalArgumentException("Players must be different player objects.");
        }
        if (player1.getColor() == player2.getColor()) {
            throw new IllegalArgumentException("Players must have different colors.");
        }

        this.board = new Board();
        this.currentPlayer = player1;
        this.state = State.IN_PROGRESS;
    }

    /**
     * Attempts to drop a disc into a column (0 through 6).
     * Returns false for invalid moves or after the game has ended.
     */
    public boolean makeMove(Player player, int column) {
        if (state != State.IN_PROGRESS || !isPlayerInGame(player)
                || player != currentPlayer || !board.canPlace(column)) {
            return false;
        }

        int placedRow = board.placeDisc(player, column);
        if (placedRow == -1) {
            return false;
        }

        if (board.canWin(player, placedRow, column)) {
            winner = player;
            state = State.WIN;
        } else if (board.isFull()) {
            state = State.DRAW;
        } else {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        return true;
    }

    private boolean isPlayerInGame(Player player) {
        return player != null && (player == player1 || player == player2);
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public State getState() {
        return state;
    }

    public Player checkWinner() {
        return winner;
    }
}
