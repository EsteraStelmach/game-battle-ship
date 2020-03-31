import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardListTest {

    BoardList boardList = new BoardList();

    @Test
    public void isSizeOfBoardListCorrect() {
        assertTrue(boardList.getAllBoard().size()==100);
    }

    @Test
    public void checkFirstAndLastBoard() { // check if first and last board on the list is correct / sprawdza czy pierwszy i osotatni board na liscie sa poprawne
        Board firstBoard = boardList.getAllBoard().get(0);
        Board lastBoard = boardList.getAllBoard().get(99);
        assertTrue(firstBoard.getColumn()==1);
        assertTrue(firstBoard.getVerse()==1);
        assertTrue(lastBoard.getColumn()==10);
        assertTrue(lastBoard.getColumn()==10);
        assertTrue(firstBoard.isEmpty());
        assertTrue(lastBoard.isEmpty());
    }
}