package tictactoe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Design extends JFrame{
	eHandler handler = new eHandler();
	ButtonGroup gr;
	JButton[][] b;
	JButton start;
	JRadioButton rbx, rb0;
	JPanel[] p;
	String me, comp;
	public Design(String s){
		super(s);
		start = new JButton("Start");
		b = new JButton[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++){
				b[i][j] = new JButton("-");
				b[i][j].setEnabled(false);
			}
		rbx = new JRadioButton("X", true);
		rb0 = new JRadioButton("0");
		gr = new ButtonGroup();
		gr.add(rbx);
		gr.add(rb0);
		p = new JPanel[5];
		p[0] = new JPanel(new GridLayout(2, 1));
		p[0].add(rbx);
		p[0].add(rb0);
		p[1] = new JPanel(new GridLayout(1, 2));
		p[1].add(p[0]);
		p[1].add(start);
		for (int i = 0; i < 3; i++){
			p[2+i] = new JPanel(new GridLayout(1, 3));
			for (int j = 0; j < 3; j++)
				p[2+i].add(b[i][j]);
		}
		add(p[1]);
		add(p[2]);
		add(p[3]);
		add(p[4]);
		setLayout(new GridLayout(4, 1));
		start.addActionListener(handler);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				b[i][j].addActionListener(handler);
	}
		
		public class eHandler implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == start){
					if (rbx.isSelected()){me = "X"; comp = "0";}
					else {me = "0"; comp = "X";}
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++)
							b[i][j].setEnabled(true);
					start.setEnabled(false);
					if (comp == "X"){
						b[1][1].setText(comp);
						b[1][1].setEnabled(false);
					}
				}
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						if (e.getSource() == b[i][j]){
							b[i][j].setText(me);
							b[i][j].setEnabled(false);
							if (b[1][1].isEnabled()){
								b[1][1].setText(comp);
								b[1][1].setEnabled(false);
							}
							else{
								short h, v, d1, d2;
								boolean flag = false;
								for(int k = 0; !flag && k < 3; k++){
									h=0; v=0; d1=0; d2=0;
									for (int n = 0; n < 3; n++){
										if (b[k][n].getText().equals(comp)) h++;
										if (b[n][k].getText().equals(comp)) v++;
										if (b[n][n].getText().equals(comp)) d1++;
										if (b[n][2-n].getText().equals(comp))d2++;
									}
									if (!flag && h == 2) for (int m = 0; m < 3; m++)
											if (b[k][m].isEnabled()){
												b[k][m].setText(comp);
												b[k][m].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && v == 2) for (int m = 0; m < 3; m++)
											if (b[m][k].isEnabled()){
												b[m][k].setText(comp);
												b[m][k].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && d1 == 2) for (int m = 0; m < 3; m++)
											if (b[m][m].isEnabled()){
												b[m][m].setText(comp);
												b[m][m].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && d2 == 2) for (int m = 0; m < 3; m++)
											if (b[m][2-m].isEnabled()){
												b[m][2-m].setText(comp);
												b[m][2-m].setEnabled(false);
												flag = true;
												break;
											}
								}
								for (int k = 0; !flag && k < 3; k++){
									h=0; v=0; d1=0; d2=0;
									for (int n = 0; n < 3; n++){
										if (b[k][n].getText().equals(me)) h++;
										if (b[n][k].getText().equals(me)) v++;
										if (b[n][n].getText().equals(me)) d1++;
										if (b[n][2-n].getText().equals(me))d2++;
									}
									if (!flag && h == 2) for (int m = 0; m < 3; m++)
											if (b[k][m].isEnabled()){
												b[k][m].setText(comp);
												b[k][m].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && v == 2) for (int m = 0; m < 3; m++)
											if (b[m][k].isEnabled()){
												b[m][k].setText(comp);
												b[m][k].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && d1 == 2) for (int m = 0; m < 3; m++)
											if (b[m][m].isEnabled()){
												b[m][m].setText(comp);
												b[m][m].setEnabled(false);
												flag = true;
												break;
											}
									if (!flag && d2 == 2) for (int m = 0; m < 3; m++)
											if (b[m][2-m].isEnabled()){
												b[m][2-m].setText(comp);
												b[m][2-m].setEnabled(false);
												flag = true;
												break;
											}
								}
								for(int k = 0; !flag && k < 3; k++)
									for(int n = 0; n < 3; n++)
										if(b[k][n].isEnabled()){
											b[k][n].setText(comp);
											b[k][n].setEnabled(false);
											flag = true;
											break;
										}
							}
										
							//rules
							if(//vertical
								(b[0][0].getText().equals(me) && (b[0][0].getText().equals(b[1][0].getText()) && b[0][0].getText().equals(b[2][0].getText()))) ||
								(b[0][1].getText().equals(me) && (b[0][1].getText().equals(b[1][1].getText()) && b[0][1].getText().equals(b[2][1].getText()))) ||
								(b[0][2].getText().equals(me) && (b[0][2].getText().equals(b[1][2].getText()) && b[0][2].getText().equals(b[2][2].getText()))) ||
								//horizontal
								(b[0][0].getText().equals(me) && (b[0][0].getText().equals(b[0][1].getText()) && b[0][0].getText().equals(b[0][2].getText()))) ||
								(b[1][0].getText().equals(me) && (b[1][0].getText().equals(b[1][1].getText()) && b[1][0].getText().equals(b[1][2].getText()))) ||
								(b[2][0].getText().equals(me) && (b[2][0].getText().equals(b[2][1].getText()) && b[2][0].getText().equals(b[2][2].getText()))) ||
								//diagonal
								(b[0][0].getText().equals(me) && (b[0][0].getText().equals(b[1][1].getText()) && b[0][0].getText().equals(b[2][2].getText()))) ||
								(b[0][2].getText().equals(me) && (b[0][2].getText().equals(b[1][1].getText()) && b[0][2].getText().equals(b[2][0].getText()))))
								JOptionPane.showMessageDialog(null, "You won!");		
							if(//vertical
								(b[0][0].getText().equals(comp) && (b[0][0].getText().equals(b[1][0].getText()) && b[0][0].getText().equals(b[2][0].getText()))) ||
								(b[0][1].getText().equals(comp) && (b[0][1].getText().equals(b[1][1].getText()) && b[0][1].getText().equals(b[2][1].getText()))) ||
								(b[0][2].getText().equals(comp) && (b[0][2].getText().equals(b[1][2].getText()) && b[0][2].getText().equals(b[2][2].getText()))) ||
								//horizontal
								(b[0][0].getText().equals(comp) && (b[0][0].getText().equals(b[0][1].getText()) && b[0][0].getText().equals(b[0][2].getText()))) ||
								(b[1][0].getText().equals(comp) && (b[1][0].getText().equals(b[1][1].getText()) && b[1][0].getText().equals(b[1][2].getText()))) ||
								(b[2][0].getText().equals(comp) && (b[2][0].getText().equals(b[2][1].getText()) && b[2][0].getText().equals(b[2][2].getText()))) ||
								//diagonal
								(b[0][0].getText().equals(comp) && (b[0][0].getText().equals(b[1][1].getText()) && b[0][0].getText().equals(b[2][2].getText()))) ||
								(b[0][2].getText().equals(comp) && (b[0][2].getText().equals(b[1][1].getText()) && b[0][2].getText().equals(b[2][0].getText()))))
								JOptionPane.showMessageDialog(null, "The computer won!");
						}
			}
			
		}
}

