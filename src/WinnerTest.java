import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerTest {

    Ship ship1= new Ship(3);
    Winner winner= new Winner();


    @Test
    public void shouldSayThatWinnerShipListIsCorrectAtTheBegging() {// check if at the begging list winnerShips is empty/ sprawdza czy na początku lista winnerShip jest pusta
        assertTrue(winner.getWinnerShips().size()==0);
    }


    @Test
    public void shouldAddSunkSipToWinnerShips() { //check if method addSunkToWinnerShip works correctly/ sprawdza czy metoda addSunkToWinnerShip działa poprawnie
        winner.addSunkSipToWinnerShips(ship1);
        assertTrue(winner.getWinnerShips().size()==1);
    }
    @Test
    public void shouldNotAddSunkSipToWinnerShips() { //check if method addSunkToWinnerShip works correctly(could not add more than 10 ships)/ sprawdza czy metoda addSunkToWinnerShip działa poprawnie(nie powinna dodac wiecej niz 10 statków
       for(int i=0;i<11;i++){
           winner.addSunkSipToWinnerShips(ship1);
        }
        assertFalse(winner.getWinnerShips().size()==11);
    }

    @Test
    public void shouldSayIsNotTheWinner() {//check if method isTheWinner works correctly/ sprawdza czy metoda isTheWinner dziala poprawnie
        for(int i=0;i<7;i++){
            winner.addSunkSipToWinnerShips(ship1);
        }
        assertFalse(winner.isTheWinner());
    }

    @Test
    public void shouldSayIsTheWinner() {//check if method isTheWinner works correctly/ sprawdza czy metoda isTheWinner dziala poprawnie
        for(int i=0;i<10;i++){
            winner.addSunkSipToWinnerShips(ship1);
        }
        assertTrue(winner.isTheWinner());
    }
}