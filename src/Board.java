import java.util.Objects;

public class Board  { //board is one pieces of 100 which are on game board / board to jeden kawalek ze 100 które znajduja sie na calej planszy gry

    final private int verse; // number of verse where is board / numer wiersza gdzie znajduje sie board
   final private int column; // number of column where is board / numer kolumny gdzie znajduje sie board
   private boolean empty; // shows if board is empty or not (is there ship or not) / pokazuje czy board jest pusty czy nie (czy jest tam statek czy nie)


   public Board(int verse, int column, boolean empty) {
        if((verse>0 && verse<=10) && (column>0 && column<=10)) {
            this.verse = verse;
            this.column = column;
            this.empty = empty;
        }else {// if parameters of board are not correctly // jesli parametry board nie sa poprawne
            this.verse=(-1);
            this.column=(-1);
            System.out.println("Board verse and column is out of bounds. Parameters are not correctly!!");
        }
    }

    protected int getVerse() { return verse; }

    protected int getColumn() { return column; }

    protected boolean isEmpty() {
        return empty;
    }

    protected void isNotEmpty(){
        this.empty=false;
    } // change variable empty for false (when is there ship, or when is shot) / zmienia zmienna empty na false ( kiedy jest tam statek albo kiedy zostala strzelona)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return verse == board.verse &&
                column == board.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(verse, column);
    }


}
