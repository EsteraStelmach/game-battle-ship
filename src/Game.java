import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Board> boardList; //list for all Boards (100) which are in boardGame //lista 100 board ktore ukladaja sie na planszy gry
    private Board board;
    private Ship findShipInTheList;
    private List<Board> computerHitList= new ArrayList<>();//list of boards which computer hit the player's ship/ lista board w ktorej computer uderzyl w statek przeciwnika
    private List<Ship> allBoardShips= new ArrayList<>();// all ships on board game/ wszystkie statki na planszy
    private List<Board> allChosenBoard= new ArrayList<>(); //all chosen boards from computer/ wszytskie wybrane board przez computer


    public Game(List<Board> boardList) {
        this.boardList = boardList;
    }

    public void addChosenBoard(Board chooseBoard) {
        allChosenBoard.add(chooseBoard);
    }

    public List<Board> getComputerHitList() {
        return computerHitList;
    }

    public void addBoardToComputerHitList(Board computerAnswer) {
        this.computerHitList.add(computerAnswer);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addToAllBoardShip(Ship ship){
        allBoardShips.add(ship);
    }


    public Ship getPlaceInTheList(Board board) {
        for (Ship helpShip : allBoardShips) {
            for (Board board1 : helpShip.getShipPlace()) {
                if (board.equals(board1)) {
                    this.findShipInTheList = helpShip;
                    break;
                }
            }
        }
        return findShipInTheList;
    }

    public void setShip(Ship ship) {  //setting ship on boardList/ ustawianie statku na boardList

        board = randomCel();
        if(ship.getShipLength()==1){
            if(isEmptyArea(boardArea(board))){
                ship.addBoardToShipPlace(board);
                board.isNotEmpty();
            }else if(!isEmptyArea(boardArea(board))){
                setShip(ship);
            }
        }else if(ship.getShipLength()>1) {
            placeForShip(ship, board);
            List<Board> helpList=checkShip(ship);
            for (Board helpBoard : helpList) {
                helpBoard.isNotEmpty();
            }
        }
    }

    protected Board randomCel(){ // random place for Board / losowe miejsce dla board

        int randomColumn =(int)(Math.random()*10+1);
        int randomVerse = (int)(Math.random()*10+1);
        for (Board helpBoard: boardList) {
            if(helpBoard.equals(new Board(randomVerse,randomColumn,true))){
                if(helpBoard.isEmpty()) { //if on this board is already a ship(empty==false) / jesli na tym board jest juz statek empty==false)
                    setBoard(helpBoard);
                    break;
                }else{
                    board=randomCel();
                    break;
                }
            }
        }
       return board;
    }



    protected List<Board> boardArea(Board board){ // szukanie pól obok statku, które go okrązaja

       List<Board> helpList= boardList
               .stream()
               .filter(board1 -> board1.getVerse()>board.getVerse()-2)
               .filter(board1 -> board1.getVerse()<board.getVerse()+2)
               .filter(board1 -> board1.getColumn()>board.getColumn()-2)
               .filter(board1 -> board1.getColumn()<board.getColumn()+2)
               .collect(Collectors.toList());

       return helpList;
    }

    private boolean isEmptyArea(List<Board> list){ //sprawdzxa czy pole okrązajace statek sa puste

        int i=0;
        for (Board helpBoard:list) {
            if(helpBoard.isEmpty()){
                i++;
            }
        }
        return i==list.size();
    }

    private List<Board> nextShipBoard(Board board){ // szuka pól na które statek sie moze rozszeyc

        List<Board> area=boardArea(board);
        List<Board> helpList=area
                .stream()
                .filter(board1 -> board1.getVerse()==board.getVerse())
                .filter(board1 -> board1.getColumn()==board.getColumn()-1)
                .collect(Collectors.toList());

        List<Board> helpList2=area
                .stream()
                .filter(board1 -> board1.getVerse()==board.getVerse())
                .filter(board1-> board1.getColumn()==board.getColumn()+1)
                .collect(Collectors.toList());

        List<Board> helpList3=area
                .stream()
                .filter(board1 -> board1.getColumn()==board.getColumn())
                .filter(board1 -> board1.getVerse()==board.getVerse()-1)
                .collect(Collectors.toList());

        List<Board> helpList4=area
                .stream()
                .filter(board1 -> board1.getColumn()==board.getColumn())
                .filter(board1 -> board1.getVerse()==board.getVerse()+1)
                .collect(Collectors.toList());

        helpList.addAll(helpList2);
        helpList.addAll(helpList3);
        helpList.addAll(helpList4);

        return  helpList;
    }

    private void placeForShip(Ship ship, Board board) { //szuka domyslnie miejsca dla statku

        ship.addBoardToShipPlace(board);

        if (isEmptyArea(boardArea(board)) && ship.getShipLengthForChange() > 1) {

            List<Board> list = nextShipBoard(board);
            Board helpBoard = list.get((int) (Math.random() * list.size()));
            if (isEmptyArea(boardArea(helpBoard))) {
                ship.setShipLengthForChange(ship.getShipLengthForChange() - 1);
                placeForShip(ship, helpBoard);
            } else {
                ship.getShipPlace().clear();
                ship.setShipLengthForChange(ship.getShipLength());
                setShip(ship);
            }
        } else if (!isEmptyArea(boardArea(board))) {
            ship.getShipPlace().clear();
            ship.setShipLengthForChange(ship.getShipLength());
            setShip(ship);
        }
    }

    private List<Board> checkShip (Ship ship) { // sprawdza rózne paprametry statku

        if (ship.getShipPlace().size() >= 3) {
            if (ship.getShipPlace().get(0).equals(ship.getShipPlace().get(2))) {
                ship.getShipPlace().clear();
                ship.setShipLengthForChange(ship.getShipLength());
                setShip(ship);
            } else if (ship.getShipPlace().size() == 4) {
                List<Board> helpList = nextShipBoard(ship.getShipPlace().get(0));
                if (ship.getShipPlace().get(1).equals(ship.getShipPlace().get(3))) {
                    ship.getShipPlace().clear();
                    ship.setShipLengthForChange(ship.getShipLength());
                    setShip(ship);
                }
                for (Board helpBoard : helpList) {
                    if (helpBoard.equals(ship.getShipPlace().get(3))) {// czy statek sie nie zapetla i n ie wychodzi z niego kwadrat
                        ship.getShipPlace().clear();
                        ship.setShipLengthForChange(ship.getShipLength());
                        setShip(ship);
                        break;
                    }
                }
            }
        }
        return ship.getShipPlace();
    }

    public  boolean isThereShip(int verse, int column){

        boolean can=false;

        for(Board helpBoard:boardList) {
            if (helpBoard.getColumn() == column && helpBoard.getVerse() == verse) {
                if (!helpBoard.isEmpty()) {
                    can = true;
                }
            }
        }
        return can;

    }
    protected Board randomCelForComputerAnswer(){
        Board board=randomCel();
        if((!board.isEmpty()) || (!allChosenBoard.contains(board))){
           board= randomCelForComputerAnswer();
        }
        return board;
    }


    private boolean isThisShipBigger(Board board){

        List<Board> helpList = nextShipBoard(board);
        int i=0;
        for (Board helpBoard : helpList) {
            if ((allChosenBoard.contains(helpBoard)) || (!helpBoard.isEmpty())) {
                i++;
            }
        }
        return !(i==helpList.size());
    }

    private Board nextComputerShipMove(Board lastComputerBoard){//to tylko wtdy kiedy bedzie hit

        Board newChooseBoard;
        List<Board> helpList = nextShipBoard(lastComputerBoard);
        int r = (int)(Math.random() * helpList.size());
        newChooseBoard = helpList.get(r);
        if((allChosenBoard.contains(newChooseBoard)) ||  (!newChooseBoard.isEmpty())) {
           newChooseBoard = nextComputerShipMove(lastComputerBoard);
        }
       return newChooseBoard;
    }

    protected Board nextComputerMoveAnswerHit(Board Board ){//tylko wtedy gdy player odpisał hit

        Board newBoard;

        if (isThisShipBigger(Board)) {
                newBoard = nextComputerShipMove(Board);//szuka czy obok osttaniego uderzenia trafionego nie ma dalej statku
        } else {// sprawdzamy czy przy pierwszym nie ma jeszcze dalej statku
                newBoard = nextComputerShipMove(computerHitList.get(0));
        }

        if(computerHitList.contains(newBoard)) {
            nextComputerMoveAnswerHit(Board);
        }
        return  newBoard;
    }

    protected void setFalseShipArea(){

        for(Board helpBoard:computerHitList) {
            for (Board help2Board : boardArea(helpBoard)) {
                addChosenBoard(help2Board);
            }
        }
        computerHitList.clear();
    }



















































}






