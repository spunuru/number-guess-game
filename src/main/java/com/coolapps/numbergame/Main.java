package com.coolapps.numbergame;

/**
 * This class is entry point to run Number guess game application.
 * 
 * 
 * @author Suresh Punuru
 *
 */
public class Main {

	/**
	 * 
	 * @param args Optionally first element can be passed on command line to indicate 
	 * the max number in the game for e.g. if user wants to search in 1..1000 range
	 * set this to 1000.
	 */
    public static void main( String[] args )
    {    	    	    	
    	Integer maxNumber = parseArguments(args);    	
    	NumberGuessGame numberGuessGame = new NumberGuessGame(maxNumber);    	
    	numberGuessGame.playGame();    	
    }
    
    /**
     * Parse first argument as int and returns.
     * Rest of the arguments are ignored, if specified.
     * @param args
     * @return
     */
    private static Integer parseArguments(String[] args) {    	
    	if (args == null || args.length == 0) {
    		return null;
    	}
    	
		try {
    		int maxNumber = Integer.parseInt(args[0]);
    		return maxNumber;
		}
		catch(NumberFormatException ex) {
    		return null;
		}
    }


}
