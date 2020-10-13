
public class Game {
    private int totalScore;
//    private Frame currentFrame;
    private Frame[] frames = new Frame[10];
    
    public Game() {
        initFrames();
    }
    
    public void setTotalScore(int tScore) {
        totalScore = tScore;
    }
    
//    public void setCurrentFrame(Frame currFrame) {
//        currentFrame = currFrame;
//    }
    
    public void setCurrentFrame(int idx, Frame currFrame) {
      frames[idx] = currFrame;
    }
    
    public int getTotalScore() {
        return totalScore;
    }
    
    public Frame getCurrentFrame(int frameId) {
        return frames[frameId-1];
    }
    
    public Frame[] getFrames() {
        return frames;
    }
    
    private void initFrames() {
        for(int i = 0; i < 10; i++) {
            frames[i] = initFrame(i+1);
        }
    }
    
    private Frame initFrame(int frameId) {
        return new Frame(frameId, "__");
    }
    
}
