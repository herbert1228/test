package lab09;

import java.util.Scanner;

public class IntegerGuess {
    int secretInteger;
    public void setSecretInteger(int secretInteger) {
        this.secretInteger = secretInteger;
    }
    public int getSecretInteger() {
        return secretInteger;
    }
    public IntegerGuess(){
        setSecretInteger((int)((20 * Math.random()+0.5)));
    }
    public int oneGuess(int anInteger){
        //System.out.println(anInteger);
        if(anInteger == this.secretInteger)
            return 0;
        if(anInteger > this.secretInteger)
            return -1;
        return 1;
    }
    public void play(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Guess an Integer : ");
            switch (oneGuess(scanner.nextInt())){
                case 0:
                    System.out.println("Congratulations! You are correct. Bye");
                    return;
                case 1:
                    System.out.println("The secret number is larger than your guessed number. Please retry.");
                    break;
                case -1:
                    System.out.println("The secret number is smaller than your guessed number. Please retry.");
                    break;
            }
        }
    }
}
