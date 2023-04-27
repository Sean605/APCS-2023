import javax.swing.*;
import java.awt.Color;

public class DiceRoller{
    private int sides;

    public DiceRoller(int sides){
        this.sides = sides;
    }

    public int getRandom(){
        return (int)(Math.random() * sides) + 1;
    }

    public void changeNumOfSides(char operation, int amount){
        if(operation == '-'){
            // Subtracts 'amount' from sides
            sides -= amount;
        }
        if(operation == '+'){
            // Adds 'amount' to sides
            sides += amount;
        }
    }
}

class NumberRaceGame extends DiceRoller{
    private int turn = 0;
    private int numberChosenBlue;
    private int numberChosenRed;
    private static int BlueScore = 0;
    private static int RedScore = 0;
    private static JFrame frame = new JFrame();
    private static JPanel bluePanel = new JPanel();
    private static JPanel redPanel = new JPanel();
    private static JButton blueButton = new JButton();
    private static JButton redButton = new JButton();

    public NumberRaceGame(int sides, int numBlue, int numRed){
        super(sides);
        this.numberChosenBlue = numBlue;
        this.numberChosenRed = numRed;
    }

    public int getBlue(){
        return numberChosenBlue;
    }

    public int getRed(){
        return numberChosenRed;
    }

    public boolean switchTurns(){
        turn++;

        if(turn % 2 == 0){
            return false;
        }

        return true;
    }

    public void userInterface(){
        // Creates playing window
        frame.setVisible(true);
        frame.setSize(1000, 1000);

        frame.add(redPanel);
        redPanel.setSize(1000, 1000);
        redPanel.setBackground(Color.RED);
        redPanel.add(redButton);

        frame.add(bluePanel);
        bluePanel.setSize(1000, 1000);
        bluePanel.setBackground(Color.BLUE);
        bluePanel.add(blueButton);
    }

    public static void main(String[] args) {
        NumberRaceGame game = new NumberRaceGame(6, 3, 5);
        game.userInterface();

        while(BlueScore < 5 || RedScore < 5){
            if(game.switchTurns()){
                if(game.getBlue() == game.getRandom()){
                    BlueScore++;
                    bluePanel.setVisible(false);
                    redPanel.setVisible(true);
                }
            }
            else{
                if(game.getRed() == game.getRandom()){
                    RedScore++;
                    bluePanel.setVisible(true);
                    redPanel.setVisible(false);
                }
            }

            game.switchTurns();
        }
    }
}