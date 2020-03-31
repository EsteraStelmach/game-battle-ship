public class Computer extends Winner{


    protected char digitToLetter(int digit){// changes int to letters from player class to be readable for player / zmienia int na literki z klasy player by byly czytane przez gracza

        char[] letters = Player.letters;
        char letter = letters[digit - 1];

        return letter;
    }
}
