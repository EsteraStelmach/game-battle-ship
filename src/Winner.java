import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Ship> winnerShips= new ArrayList<Ship>();

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
