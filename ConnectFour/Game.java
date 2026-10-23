public class Game {
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;
    State state;
    Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
        this.state = State.IN_PROGRESS;
    }

    public boolean makeMove(Player player, int column) {
        if (state != State.IN_PROGRESS || player == null
                || (player != player1 && player != player2)
                || player != currentPlayer || !board.canPlace(column)) {
            return false;
        }

        int row = board.placeDisc(player, column);
        if (row == -1) {
            return false;
        }

        if (board.canWin(player, row, column)) {
            winner = player;
            state = State.WIN;
        } else if (board.isFull()) {
            state = State.DRAW;
        } else {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        return true;
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
