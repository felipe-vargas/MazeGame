package levels;

import game.Game;
import game.Level;

public class Level1 implements Level {
	public void load() {
		Game.gridH[4][1] = true;
		Game.gridH[8][1] = true;
		Game.gridH[5][2] = true;
		Game.gridH[2][3] = true;
		Game.gridH[5][3] = true;
		Game.gridH[6][3] = true;
		Game.gridH[7][3] = true;
		Game.gridH[8][3] = true;
		Game.gridH[2][4] = true;
		Game.gridH[6][4] = true;
		Game.gridH[7][6] = true;
		Game.gridH[9][6] = true;
		Game.gridH[3][7] = true;
		Game.gridH[4][7] = true;
		Game.gridH[3][8] = true;
		Game.gridH[2][9] = true;
		Game.gridH[5][9] = true;
		Game.gridH[7][9] = true;
		Game.gridH[9][9] = true;
		Game.gridH[1][10] = true;
		Game.gridH[5][10] = true;
		
		Game.gridW[5][1] = true;
		Game.gridW[1][2] = true;
		Game.gridW[2][2] = true;
		Game.gridW[3][2] = true;
		Game.gridW[7][2] = true;
		Game.gridW[9][2] = true;
		Game.gridW[9][3] = true;
		Game.gridW[10][3] = true;
		Game.gridW[3][4] = true;
		Game.gridW[4][4] = true;
		Game.gridW[5][4] = true;
		Game.gridW[6][4] = true;
		Game.gridW[1][5] = true;
		Game.gridW[2][5] = true;
		Game.gridW[3][5] = true;
		Game.gridW[4][5] = true;
		Game.gridW[6][5] = true;
		Game.gridW[7][5] = true;
		Game.gridW[10][5] = true;
		Game.gridW[2][6] = true;
		Game.gridW[3][6] = true;
		Game.gridW[5][6] = true;
		Game.gridW[6][6] = true;
		Game.gridW[7][6] = true;
		Game.gridW[4][7] = true;
		Game.gridW[1][8] = true;
		Game.gridW[3][8] = true;
		Game.gridW[6][8] = true;
		Game.gridW[7][8] = true;
		Game.gridW[10][8] = true;
		Game.gridW[2][9] = true;
	}
}
