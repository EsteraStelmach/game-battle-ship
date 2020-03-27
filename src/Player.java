public class Player extends Winner{

   protected static char[] letters={'A','B','C','D','E','F','G','H','I','J'};
   private int column;
   private int verse;

    public int getColumn() {
        return column;
    }

    public int getVerse() {
        return verse;
    }

    protected Board setBoard(String line){
       readAnswer(line);
       Board board= new Board(verse,column,false);
       return board;
   }


   protected void readAnswer(String line) {

       String helpLine=line.toUpperCase().trim();

       int position = helpLine.length()-1;
       char[] helpArray =helpLine.toCharArray();
       verse = Character.getNumericValue(helpArray[position]);
       if(verse==0){
           verse=10;
       }
       char letter = helpLine.charAt(0);
       int i;
       for (i = 1; i <= letters.length; i++) {
           if (letters[i - 1] == letter) {
               column = i;
               break;
           }
       }
   }










}
