import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Ship> winnerShips= new ArrayList<>(10);// list where are added sunk ships/ lista gdzie dodajemy zatopione statki

    public List<Ship> getWinnerShips() {
        return winnerShips;
    }

    protected void addSunkSipToWinnerShips(Ship ship){
        if(winnerShips.size()<10) {
            winnerShips.add(ship);
        }else {
            System.out.println("Ship can not be added to winnerShipList. There is already 10 ships!");
        }
    }

    protected boolean isTheWinner(){// check if player of computer win / sprawdza czy player czy komputer wygral

        if(winnerShips.size()==10){
            return true;
        }else {
            return false;
        }
    }
}
