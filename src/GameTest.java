import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    BoardList boardList = new BoardList();
    List<Board> allBoards = boardList.getAllBoard();
    Game game= new Game(allBoards);
    Board board;

    @Test
    public void isRandomVerseAndRandomColumnInRange() { // check if verse and column are correct / sprawdza czy verse o column sa poprawne
        board = game.randomCel();
        assertTrue((board.getVerse()>0) && (board.getVerse()<=10));
        assertTrue((board.getColumn()>0) && (board.getColumn()<=10));
    }

    //THIS TESTS ARE NOT DONE!!

    @Test
    public void getComputerHitList() {
    }

    @Test
    public void setComputerHitList() {
    }

    @Test
    public void setBoard() {
    }

    @Test
    public void addToAllBoardShip() {
    }

    @Test
    public void getPlaceInTheList() {
    }

    @Test
    public void setShip() {
    }

    @Test
    public void randomCel() {
    }

    @Test
    public void boardArea() {
    }

    @Test
    public void isThereShip() {
    }

    @Test
    public void randomCelForComputerAnswer() {
    }

    @Test
    public void nextComputerMoveAnswerHit() {
    }

    @Test
    public void setFalseShipArea() {
    }
}