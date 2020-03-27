import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {



    Board board1 = new Board(4, 5, true);
    Board board2 = new Board(4, 5, false);
    Board board3 = new Board(6,10,false); // this board should not exists / ten board nie powinien istniec
    Board board4 = new Board(5,11,false); // this board should not exists / ten board nie powinien istniec


    @Test
    public void shouldSetUpBoard(){ //check if correct board is not null / sprawdza czy prawdziwy board nie jest null
        assertNotNull(board3);
    }

    @Test
    public void shouldNotSetUpBoard(){ //check if wrong board can exists / sprawdza czy zly board moze isniec
        assertTrue(board4.getColumn()==-1);
    }

    @Test
    public void shouldGetColumnCorrectly() { // check is method getColumn works correctly / sprawdza czy metoda getColumn dziala prawidlowo
        assertTrue(board1.getColumn()==5);
    }

    @Test
    public void shouldSayThatIsEmpty() { // check is method getColumn works correctly / sprawdza czy metoda getColumn dziala prawidlowo
        assertTrue(board1.isEmpty()==true);
    }

    @Test
    public void shouldSayThatIsNotEmpty() { // check is method isNotEmpty works correctly / sprawdza czy metoda isNotEmpty dziala prawidlowo
        board1.isNotEmpty();
        assertTrue(!board1.isEmpty());
        board2.isNotEmpty();
        assertTrue(!board2.isEmpty());
    }

    @Test
    public void shouldSayBoardsAreEquals() { //  check is method equals works correctly / sprawdza czy metoda equals dziala prawidlowo
        assertTrue(board1.equals(board2));
    }

    @Test
    public void shouldSayBoardsAreNotEquals() { //  check is method equals works correctly / sprawdza czy metoda equals dziala prawidlowo
        assertFalse(board2.equals(board3));
    }
}