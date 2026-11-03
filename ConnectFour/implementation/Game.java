public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;
    private Player winner;
    private GameState state;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
        this.winner = null;
        this.state = GameState.IN_PROGRESS;
    }

    public boolean makeMove(Player player, int column) {
        if (state != GameState.IN_PROGRESS || player != currentPlayer || winner != null) {
            return false;
        }

        int row = board.placeDisc(column, player.getColor());
        if (row == -1) {
            return false;
        }

        if (board.checkWin(row, column, player.getColor())) {
            winner = currentPlayer;
            state = GameState.WON;
        } else if (board.isFull()) {
            state = GameState.DRAW;
        } else {
            switchPlayer();
        }

        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getState() {
        return state;
    }
}
