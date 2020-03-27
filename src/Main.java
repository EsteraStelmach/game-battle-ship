import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){

       BoardList computerGameBoardList= new BoardList(); //pole gry komputera
       BoardList playerGameBoardList= new BoardList(); //pole gry gracza

       Player player= new Player();
       Computer computer= new Computer();

       Ship hitShip;

       List<Board> computerGameBoard=computerGameBoardList.getAllBoard();//pole gry komputera
       List<Board> playerGameBoard= playerGameBoardList.getAllBoard(); //pole gry gracza

      Game computerBoard= new Game(computerGameBoard);//dotyczy planszy komputera
      Game playerBoard= new Game(playerGameBoard);//dotyczy planszy gracza

        Board computerAnswerField=playerBoard.randomCelForComputerAnswer();

       Ship ship4=new Ship(4);
       Ship ship31=new Ship(3);
       Ship ship32=new Ship(3);
       Ship ship21=new Ship(2);
       Ship ship22=new Ship(2);
       Ship ship23=new Ship(2);
       Ship ship11=new Ship(1);
       Ship ship12=new Ship(1);
       Ship ship13=new Ship(1);
       Ship ship14=new Ship(1);

       computerBoard.addToAllBoardShip(ship4);
       computerBoard.addToAllBoardShip(ship31);
       computerBoard.addToAllBoardShip(ship32);
       computerBoard.addToAllBoardShip(ship21);
       computerBoard.addToAllBoardShip(ship22);
       computerBoard.addToAllBoardShip(ship23);
       computerBoard.addToAllBoardShip(ship11);
       computerBoard.addToAllBoardShip(ship12);
       computerBoard.addToAllBoardShip(ship13);
       computerBoard.addToAllBoardShip(ship14);

        //komputer ustawia statki na swojej planszy

        computerBoard.setShip(ship4);
        computerBoard.setShip(ship31);
        computerBoard.setShip(ship32);
        computerBoard.setShip(ship21);
        computerBoard.setShip(ship22);
        computerBoard.setShip(ship23);
        computerBoard.setShip(ship11);
        computerBoard.setShip(ship12);
        computerBoard.setShip(ship13);
        computerBoard.setShip(ship14);

       System.out.println("Hello! Do you want to play with me?:)" +
               "Set up all your ships and we'll start :)" +
               "Start first and enter the field you bet.");

       Scanner playerInPut= new Scanner(System.in);

        String hitPattern=" *[hH][iI][tT] *";
        String emptyPattern= " *[eE][mM][pP][tT][yY] *";
        String sunkPattern= ".*[sS][uU][nN][kK].*";
        String playerAnswerPosition=" *[a-jA-J] *[1-9]0? *";

       while (playerInPut.hasNextLine()) {
           String playerAnswer=playerInPut.nextLine();

           if(Pattern.matches(playerAnswerPosition,playerAnswer)) {

               player.readAnswer(playerAnswer);

               if (computerBoard.isThereShip(player.getVerse(), player.getColumn())) { //gracz trafił w statek
                   hitShip = computerBoard.getPlaceInTheList(player.setBoard(playerAnswer));
                   hitShip.addSunk();
                   if (!hitShip.isShipSunk()) {
                       System.out.println("Hit!" +
                               "You can enter field one more time!");
                   }else {
                       player.addSunkSipToWinnerShips(hitShip);
                       if(player.isTheWinner()){
                           System.out.println("Hit and sunk......You win!! Congratulations!!");
                       }else {
                           System.out.println("Hit and Sunk! You are lucky!" +
                                   "You can enter field one more time!");
                       }
                   }
               } else {
                   if(playerBoard.getComputerHitList().size()==0){
                       computerAnswerField=playerBoard.randomCel();//statki trafione wczesnioej sa juz zatopione
                   }else {
                       computerAnswerField =playerBoard.nextComputerMoveAnswerHit(playerBoard.getComputerHitList().get(playerBoard.getComputerHitList().size()-1));
                   }
                   playerBoard.addChosenBoard(computerAnswerField);
               System.out.println("Empty!! Now my turn." +
                               "I choose: " + computer.digitToLetter(computerAnswerField.getColumn()) + " " + computerAnswerField.getVerse());
                       System.out.println("Please, answer only: 'Hit!', 'Hit and Sunk' or 'Empty'");
               }
           }else if(Pattern.matches(hitPattern,playerAnswer)){// gracza board //kiedy odpowiedz gracza to hit
               System.out.println("Yes! I'm a good player.");
               playerBoard.setComputerHitList(computerAnswerField);
               computerAnswerField=playerBoard.nextComputerMoveAnswerHit(playerBoard.getComputerHitList().get(playerBoard.getComputerHitList().size()-1));
               playerBoard.addChosenBoard(computerAnswerField);
               System.out.println("I choose: " + computer.digitToLetter(computerAnswerField.getColumn()) + " " + computerAnswerField.getVerse());
               System.out.println("Please, answer only: 'Hit!', 'Hit and Sunk' or 'Empty'");

           }else if(Pattern.matches(sunkPattern,playerAnswer)){
               playerBoard.setComputerHitList(computerAnswerField);
               System.out.println("Yeah! I'm the Best!");
               computer.addSunkSipToWinnerShips(playerBoard.getPlaceInTheList(computerAnswerField));
               playerBoard.setFalseShipArea();
               if(computer.isTheWinner()){
                   System.out.println("I win!!!");
                   System.out.println("Don't worry. You are also good. Thank you for game :)");
               }else {
                   computerAnswerField = playerBoard.randomCelForComputerAnswer();
                   playerBoard.addChosenBoard(computerAnswerField);
                   System.out.println("I choose: " + computer.digitToLetter(computerAnswerField.getColumn()) + " " + computerAnswerField.getVerse());
                   System.out.println("Please, answer only: 'Hit!', 'Hit and Sunk' or 'Empty'");
               }

           }else  if(Pattern.matches(emptyPattern,playerAnswer)){
               System.out.println("No! this time i did not have lucky :( now your turn. Write your turn");

           }else {
               System.out.println("You write something wrong.First write column and than number of verse(A 10) or" +
                       "'Hit!', 'Hit and Sunk' or 'Empty'");
           }

       }

















































    }


}



