package com.coolapps.numbergame;

public class Main {

    public static void main( String[] args )
    {    	    	    	
    	Integer maxNumber = parseArguments(args);    	
    	NumberGuessGame numberGuessGame = new NumberGuessGame(maxNumber);    	
    	numberGuessGame.playGame();    	
    }
    
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
