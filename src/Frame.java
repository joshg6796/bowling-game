
public class Frame {

    private int id;
    private String input;
    private int score;
    private boolean scoreAssigned;
    
    public Frame() {
        
    }
    
    public Frame(int frameId, String frameInput) {
        id = frameId;
        input = frameInput;
        scoreAssigned = false;
    }
    
    public void setFrameId(int frameId) {
        id = frameId;
    }
    
    public void setFrameInput(String frameInput) {
        input = frameInput;
    }
    
    public void setFrameScore(int frameScore) {
        score = frameScore;
    }
    
    public void setFrameScoreAssigned(boolean frameScoreAssigned) {
        scoreAssigned = frameScoreAssigned;
    }
    
    public int getFrameId() {
        return id;
    }
    
    public String getFrameInput() {
        return input;
    }
    
    public int getFrameScore() {
        return score;
    }
    
    public boolean getFrameScoreAssigned() {
        return scoreAssigned;
    }
    
}
