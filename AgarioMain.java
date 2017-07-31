package tr.org.linux.kamp.Agario;

import java.awt.Color;

import tr.org.linux.kamp.Agario.logic.GameLogic;
import tr.org.linux.kamp.Agario.model.Difficulty;

public class AgarioMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameLogic gameLogic = new GameLogic("M", Color.CYAN, Difficulty.EASY );
		gameLogic.startApplication();
		

	}

}
