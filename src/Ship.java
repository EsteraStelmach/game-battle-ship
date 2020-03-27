import java.util.ArrayList;
import java.util.List;

public class Ship { // is responsible for making ships


  private final int shipLength; // length of ship // dlugosc statku
  private int shipLengthForChange; // will change when ship is set on board game / jest zmieniana kiedy ustawiamy statek na planszy
  private List<Board> shipPlace=new ArrayList(); //ship is created from boards / statek sklada sie z board
  private int sunk=0; // counts how much times ship was shot / liczy ile razy statek byl strzelony


  public Ship(int shipLength) {
      if(shipLength<=4 && shipLength>0) {
          this.shipLength = shipLength;
          this.shipLengthForChange = shipLength;
      }else { // when parameter is not correct
          this.shipLength = -1;
          this.shipLengthForChange = -1;
          System.out.println("Ship length is out of bounds!! Parameter in ship object is not correct.");
      }
  }

    protected int getShipLength() {
        return shipLength;
    }

    public int getSunk() {
        return sunk;
    }

    public void addSunk() { // method for changing variable sunk(when ship was shot) / metoda do zmiany zmiennej sunk ( kiedy statek byl strzelony)
        sunk++;
    }

    protected List<Board> getShipPlace() {
        return shipPlace;
    }

    protected void addBoardToShipPlace(Board board) { // method adding board to list shipPlace / metoda dodaje board to listy shipPlace
      if(shipPlace.size()<shipLength) {
          this.shipPlace.add(board);
      }else{
          System.out.println("Can not add board to the ship list. It is enough Boards on the list!!");
      }
    }

    protected int getShipLengthForChange() {
        return shipLengthForChange;
    }

    protected void setShipLengthForChange(int shipLengthForChange) {
      if(shipLengthForChange>0 && shipLengthForChange<=4) {
          this.shipLengthForChange = shipLengthForChange;
      }else{
          System.out.println("Ship length for change can not change.Is out of bounds!!");
      }
    }

    protected boolean isShipSunk(){ // shows is ship is already sunk or not / pokazuje czy statek zatonal czy nie
        if(sunk==getShipLength()){return true;}
        else if(sunk>getShipLength()){
            System.out.println("Sunk is bigger than shipLength!! The biggest value of sunk should be the value of shipLength");
            return false;
        } else {return false;}
    }









































}




