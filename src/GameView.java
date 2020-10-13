
public class GameView {
    public void printScoreboard(Frame[] frames) {
        for(Frame f : frames) {
            if(f.getFrameId()==1) System.out.print("| Frame | ");
            System.out.print(f.getFrameId() + " | ");
        }
        System.out.println("\n|---|---|---|---|---|---|---|---|---|---|---|");
        for(Frame f : frames) {
            if(f.getFrameId()==1) System.out.print("| Input | ");
            System.out.print(f.getFrameInput() + " | ");
        }
        System.out.println();
        for(Frame f : frames) {
            if(f.getFrameId()==1) System.out.print("| Score | ");
            if(f.getFrameScoreAssigned()) {
                System.out.print(f.getFrameScore() + " | ");
            } else {
                System.out.print("__ | ");
            }
        }
        System.out.println();
    }
}
