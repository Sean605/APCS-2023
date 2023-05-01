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
    private boolean turn;
    private int numberChosenBlue;
    private int numberChosenRed;
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

    public void switchTurns(){
        turn = !turn;
    }

    public boolean getTurn(){
        return turn;
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
        // game.userInterface();
        int blueScore = 0;
        int redScore = 0;

        while(blueScore < 5 || redScore < 5){
            if(game.getTurn()){
                if(game.getBlue() == game.getRandom()){
                    blueScore++;
                    bluePanel.setVisible(false);
                    redPanel.setVisible(true);
                }
            }
            else{
                if(game.getRed() == game.getRandom()){
                    redScore++;
                    bluePanel.setVisible(true);
                    redPanel.setVisible(false);
                }
            }

            game.switchTurns();
        }

        if(blueScore == 5){
            System.out.println("Blue wins!");
        }
        else{
            System.out.println("Red wins!");
        }
    }
}