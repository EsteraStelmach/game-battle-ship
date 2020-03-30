import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Ship> winnerShips= new ArrayList<Ship>(10);

    public List<Ship> getWinnerShips() {
        return winnerShips;
    }

    protected void addSunkSipToWinnerShips(Ship ship){
        winnerShips.add(ship);
    }

    protected boolean isTheWinner(){

        if(winnerShips.size()==10){
            return true;
        }else {
            return false;
        }
    }
}
