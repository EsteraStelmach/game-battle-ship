import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    Ship ship1 = new Ship(4);
    Ship ship2 = new Ship(0);//this ship should not exists / ten statek nie powinien istniec
    Board board = new Board(4,5,true);


    @Test
    public void shouldSetUpShip() { //check if ship is not null
        assertNotNull(ship1);
    }

    @Test
    public void shouldNotSetUpShip() { //check if wrong ship can exists / sprawdza czy zly statek moze istniec
        assertTrue(ship2.getShipLength()==-1);
    }

    @Test
    public void shouldSayIsEquals() { //check if variables shipLengthForChange and shipLength are equals // sprawdza czy zmienne shipLengthForChange i shipLength sa rowne
        assertTrue(ship1.getShipLengthForChange() == ship1.getShipLength());
    }

    @Test
    public void shouldSayShipLengthIsCorrect() { //check variable shipLength / sprawdza  zmienna shipLength
        assertTrue(ship1.getShipLength()==4);
    }

    @Test
    public void shouldSayShipLengthForChangeIsCorrect() { //check variable shipLengthForChange / sprawdza  zmienna shipLengthForChange
        assertTrue(ship1.getShipLengthForChange()==4);
    }

    @Test
    public void shouldSetGoodShipLengthForChange() { //check if variable shipLengthForChange can change correctly / sprawdza czy zmienna shipLengthForChange zmienia sie wlasciwie
        ship1.setShipLengthForChange(2);
        assertTrue(ship1.getShipLengthForChange()==2);
    }

    @Test
    public void shouldNotSetShipLengthForChange() { //check if variable shipLengthForChange can  not change / sprawdza czy zmienna shipLengthForChange nie zmienia sie
        ship1.setShipLengthForChange(5);
        assertFalse(ship1.getShipLengthForChange()==5);
    }

    @Test
    public void shouldSayShipPlaceIsCorrectAtTheBeginning() { //check if ArrayList shipPlace is empty at the beginning /sprawdza liste shipPlace czy na poczatku jest pusta
        assertTrue(ship1.getShipPlace().size()==0);
    }

    @Test
    public void shouldSayBoardIsAddToShipPlace() { //check if Board is added to ArrayList shipPlace /sprawdza czy board jest dodany do listy shipPlace
        ship1.addBoardToShipPlace(board);
        assertEquals(board,ship1.getShipPlace().get(0));
    }

    @Test
    public void shouldSayBoardIsNotAddToShipPlace() { //check if Board is not added to ArrayList shipPlace / sprawdza czy board jest nie dodany do listy shipPlace
        for(int i=0;i<=4;i++){
            ship1.addBoardToShipPlace(board);
        }
        assertFalse(ship1.getShipPlace().size()==5);
    }

    @Test
    public void ShouldSaySunkIsZeroAtTheBeginning() { //check if sunk == 0 at the beginning / sprawdza czy sunk == 0 na poczatku
        assertTrue(ship1.getSunk()==0);
    }

    @Test
    public void shouldSayShipIsAddToSunk() { // check if method addSunk works correctly / sprawdza czy metoda addSunk dziala poprawnie
        ship1.addSunk();
        assertFalse(ship1.getSunk()==0);
    }

    @Test
    public void shouldSayThatShipIsShipSunk() {
        for(int i=0;i<4;i++){
            ship1.addSunk(); }
        assertTrue(ship1.getSunk()==ship1.getShipLength());
    }

    @Test
    public void shouldSayThatShipIsNotShipSunk() {
        for(int i=0;i<3;i++){
            ship1.addSunk(); }
        assertFalse(ship1.getSunk()==ship1.getShipLength());
    }

    @Test
    public void shouldSaySunkHasToBigValue() {
        for(int i=0;i<=4;i++){
            ship1.addSunk(); }
        assertFalse(ship1.getSunk()==ship1.getShipLength());
    }




























































}