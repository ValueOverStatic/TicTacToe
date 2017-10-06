package tictactoe;

import javax.swing.JFrame;

public class MainTicTacToe {
	public static void main(String argv[]){
		Design d = new Design("Tic Tac Toe");
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setSize(250, 180);
		d.setResizable(false);
		d.setLocationRelativeTo(null);
	}

}
