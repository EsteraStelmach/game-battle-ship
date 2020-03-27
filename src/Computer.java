public class Computer extends Winner{


    protected char digitToLetter(int digit){

        char[] letters=Player.letters;
        char letter= letters[digit-1];

        return letter;
    }
}
