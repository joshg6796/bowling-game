
public class GameController {
    private Game gameModel;
    private GameView gameView;
    
    public GameController(Game gModel, GameView gView) {
        gameModel = gModel;
        gameView = gView;
    }
    
    public boolean bowl(int frameId, String input, int turnNumber) {
        Frame currFrame = gameModel.getCurrentFrame(frameId);
        String currInput = formatInput(input);
        String prevInput = currFrame.getFrameInput();
        if(!validateInput(input, prevInput, frameId, turnNumber)) {
            return false;
        } else {
            String finalInput = "";
            if(prevInput.equals("__")) {
                finalInput = currInput;
            } else {
                finalInput = prevInput + " " + currInput;
            }
            currFrame.setFrameInput(finalInput);
            if(frameId > 1) {
                Frame prevFrame = gameModel.getCurrentFrame(frameId-1);
                String prevFrameInput = prevFrame.getFrameInput();
                int totalScore = gameModel.getTotalScore();
                int newScore = totalScore;
                if(prevFrameInput.equals("X")) {
                    if(turnNumber == 2) {
                        int currInputValue = 0;
                        int prevInputValue = 0;
                        if (prevInput.equals("X")) {
                            prevInputValue = 10;
                        } else if (!prevInput.equals("-")) {
                            prevInputValue = Integer.parseInt(prevInput);
                        } 
                        if(currInput.equals("/")) {
                            currInputValue = 10;
                            prevInputValue = 0;
                        } else if (currInput.equals("-")) {
                            currInputValue = 0;
                        } else if (currInput.equals("X")) {
                            currInputValue = 10;
                        } else {
                            currInputValue = Integer.parseInt(currInput);
                        }
                        newScore = totalScore + 10 + prevInputValue + currInputValue;
                        prevFrame.setFrameScore(newScore);
                        prevFrame.setFrameScoreAssigned(true);
                        gameModel.setTotalScore(newScore);
                    } else {
                        if(frameId > 2) {
                            Frame prev2Frame = gameModel.getCurrentFrame(frameId-2);
                            String prev2FrameInput = prev2Frame.getFrameInput();
                            boolean prev2FrameScoreAssigned = prev2Frame.getFrameScoreAssigned();
                            if(prev2FrameInput.equals("X") && prevFrameInput.equals("X") && !prev2FrameScoreAssigned) {
                                newScore = totalScore + 30;
                                prev2Frame.setFrameScore(newScore);
                                prev2Frame.setFrameScoreAssigned(true);
                                gameModel.setTotalScore(newScore);
                            }

                        }
                    }
                } else {
                    String[] prevFrameInputArr = prevFrameInput.split(" ");
                    String prevFirstInput = prevFrameInputArr[0];
                    String prevSecondInput = null;
                    if(prevFrameInputArr.length > 1) {
                        prevSecondInput = prevFrameInputArr[1];
                    }
                    if(prevSecondInput != null && prevSecondInput.equals("/") && turnNumber == 1) {
                        if(currInput.equals("-")) {
                            newScore = totalScore + 10;
                        } else if(currInput.equals("X")) {
                            newScore = totalScore + 20;
                        } else{
                            newScore = totalScore + 10 + Integer.parseInt(currInput);
                        }
                        prevFrame.setFrameScore(newScore);
                        prevFrame.setFrameScoreAssigned(true);
                        gameModel.setTotalScore(newScore);
                    }
                }
            }
            if(turnNumber == 2 && !prevInput.equals("X") && !currInput.equals("/")) { 
                int totalScore = gameModel.getTotalScore();
                int newScore = totalScore;
                if(!prevInput.equals("-") && currInput.equals("-")) {
                    newScore = totalScore + Integer.parseInt(prevInput);
                } else if(prevInput.equals("-") && !currInput.equals("-")) {
                    newScore = totalScore + Integer.parseInt(currInput);
                } else if(!prevInput.equals("-") && !currInput.equals("-")) {
                    newScore = totalScore + Integer.parseInt(prevInput) + Integer.parseInt(currInput);
                }
                currFrame.setFrameScore(newScore);
                currFrame.setFrameScoreAssigned(true);
                gameModel.setTotalScore(newScore);
            }
            else if(turnNumber == 3) {
                int totalScore = gameModel.getTotalScore();
                int newScore = totalScore;
                String prevFirstInput = prevInput.split(" ")[0];
                String prevSecondInput = prevInput.split(" ")[1];
                int prevFirstInputValue = 0;
                int prevSecondInputValue = 0;
                int currInputValue = 0;
                if (prevFirstInput.equals("X")) {
                    prevFirstInputValue = 10;
                } else if (!prevFirstInput.equals("-")) {
                    prevFirstInputValue = Integer.parseInt(prevFirstInput);
                } 
                if (prevSecondInput.equals("X") || prevSecondInput.equals("/")) {
                    prevSecondInputValue = 10;
                } else if (!prevSecondInput.equals("-")) {
                    prevSecondInputValue = Integer.parseInt(prevSecondInput);
                } 
                if (currInput.equals("X") || currInput.equals("/")) {
                    currInputValue = 10;
                } else if (!currInput.equals("-")) {
                    currInputValue = Integer.parseInt(currInput);
                } 
                newScore = totalScore + prevFirstInputValue + prevSecondInputValue + currInputValue;
                currFrame.setFrameScore(newScore);
                currFrame.setFrameScoreAssigned(true);
                gameModel.setTotalScore(newScore);
            }
            return true;
        }
    }
    
    public void updateView() {
        gameView.printScoreboard(gameModel.getFrames());
    }
    
    private String formatInput(String input) {
        return input.replace("strike", "X").replace("spare", "/").replace("miss", "-");
    }
    
    private boolean validateInput(String input, String prevInput, int frameId, int turnNumber) {
        boolean valid = true;
        if(turnNumber == 1 && input.equals("spare")) {
            valid = false;
        }
        if(frameId < 10 && turnNumber == 2 && input.equals("strike")) {
            valid = false;
        }
        if(frameId == 10 && turnNumber == 2 && input.equals("strike") && !prevInput.equals("X")) {
            valid = false;
        }
        if(frameId == 10 && turnNumber == 3 && input.equals("strike")) {
            if(prevInput.split(" ")[0].equals("X") && !prevInput.split(" ")[1].equals("X")) {
                valid = false;
            }
        }
        if(frameId == 10 && turnNumber == 3 && input.equals("spare")) {
            if(!prevInput.split(" ")[0].equals("X") || prevInput.split(" ")[1].equals("X")) {
                valid = false;
            }
        }
        if(frameId == 10 && turnNumber == 3 && !input.equals("spare") && !input.equals("strike") && !input.equals("miss")) {
            try {
                int secondTurn = Integer.parseInt(prevInput.split(" ")[1]);
                int thirdTurn = Integer.parseInt(input);
                if(secondTurn + thirdTurn >= 10) {
                    valid = false;
                }
            } catch (NumberFormatException ne) {
                
            }
        }
        try {
            int inputVal = Integer.parseInt(input);
            if(inputVal > 9 || inputVal < 0) {
                valid = false;
            }
            try {
                int prevInputVal = Integer.parseInt(prevInput);
                if(prevInputVal + inputVal >= 10) {
                    valid = false;
                }
            } catch (NumberFormatException ne) {
                
            }
        } catch(NumberFormatException ne) {
            if(!input.equals("strike") && !input.equals("spare") && !input.equals("miss")) {
                valid = false;
            } 
        }
        return valid;
    }
}
