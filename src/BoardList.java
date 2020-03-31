import java.util.ArrayList;
import java.util.List;

public class BoardList {

    private List<Board> allBoard; //List of all Board in one boardGame(100) / lista 100 board na jednej planszy gry

    public BoardList() {
        allBoard = makeAllBoard();
    }

    private List<Board> makeAllBoard() { //makes all boards / tworzy wszytskie boards

        allBoard = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                Board board = new Board(i, j, true);
                allBoard.add(board);
            }
        }
        return allBoard;
    }

    public List<Board> getAllBoard() {
        return allBoard;
    }

}