import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Game model = new Game();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter ball rolls here: ");
        boolean isFirst = true;

        int frame = 1;
        int turn = 1;
        int turnLimit = 2;
        while (frame < 11) {
            if(!isFirst) {
                scanner = new Scanner(System.in); 
                System.out.print("Enter ball rolls here: ");
            } else {
                isFirst = false;
            }

            String input = scanner.nextLine().toLowerCase();
            boolean validBowl = true;
            if(turn <= turnLimit) {
                validBowl = controller.bowl(frame, input, turn);
                if(validBowl) {
                    if(frame == 10) {
                        if(turn == turnLimit) {
                            frame++;
                        }
                        if(input.equals("strike") || input.equals("spare")) {
                            turnLimit = 3;
                        }
                        turn++;
                    }
                    else if(turn >= turnLimit || input.equalsIgnoreCase("strike")) {
                        frame++;
                        turn = 1;
                    }
                    else {
                        turn++;
                    }
                }
            } 
            if(validBowl) {
                controller.updateView();
            } else {
                System.err.println("Invalid Input: Please try again.");
            }
        }
    }
}
